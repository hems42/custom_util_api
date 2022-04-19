package com.util.city_api.service.concrete;

import org.springframework.stereotype.Service;

import com.util.city_api.core.exception.exceptionModels.UnSuccessfulException;
import com.util.city_api.entity._core.User;
import com.util.city_api.entity.security.ConfirmationToken;
import com.util.city_api.entity.security.RefreshToken;
import com.util.city_api.product_core.dto._coreDto.UserDto;
import com.util.city_api.product_core.dtoConvertor.UserDtoConvertor;
import com.util.city_api.product_core.request.createRequest.LoginRequest;
import com.util.city_api.product_core.request.createRequest.SignupRequest;
import com.util.city_api.product_core.request.createRequest.UserCreateRequest;
import com.util.city_api.product_core.response.LogOutResponse;
import com.util.city_api.product_core.response.RefreshTokenResponse;
import com.util.city_api.product_core.response.RegistrationResponse;
import com.util.city_api.product_core.response.SignupReponse;
import com.util.city_api.service._abstract.IAccesTokenService;
import com.util.city_api.service._abstract.IAuthService;
import com.util.city_api.service._abstract.IConfirmationTokenService;
import com.util.city_api.service._abstract.IRefreshTokenService;
import com.util.city_api.service._abstract.IUserService;

import lombok.extern.slf4j.Slf4j;

import static com.util.city_api.core.constant.CoreConstantExceptionErrorCode.*;
import static com.util.city_api.core.constant.CoreEnumExceptionMessages.*;

@Service
@Slf4j(topic = "authService")
public class AuthService implements IAuthService{
	
	
	final private IUserService userService;
    final private IAccesTokenService accessTokenService;
    final private IRefreshTokenService refreshTokenService;
    final private IConfirmationTokenService confirmationTokenService;
    final private UserDtoConvertor userDtoConvertor;
	
	public AuthService(IUserService userService,
			IAccesTokenService accessTokenService,
			IRefreshTokenService refreshTokenService,
			IConfirmationTokenService confirmationTokenService,
			UserDtoConvertor userDtoconvertor)
	{
		this.userService =userService;
		this.accessTokenService = accessTokenService;
		this.refreshTokenService = refreshTokenService;
		this.confirmationTokenService = confirmationTokenService;
		this.userDtoConvertor = userDtoconvertor;
	}
	
	
	

	@Override
	public SignupReponse signup(SignupRequest signupRequest) {
		
		String logMetodTitle ="signup metod : -> ";
		UserDto  _userDto =null;
		User _user = null;
		String _accessToken = null;
		RefreshToken _refreshToken = null;
		ConfirmationToken _confirmationToken = null;
		
		
		/* Logic Onion
		 * 
		 * request ok
		 * user created allready ??
		 * user created successfuly ??
		 * refresh token create and saved
		 * accesstoken create and saved
		 * confirm token create and saved
		 * email send 
		 * 
		 */
		 
	
	 
		if(!userService.isExistUserByEmail(signupRequest.getEmail()))
		{
			log.info(logMetodTitle + "user not already created by email");
			
			if(!userService.isExistUserByUserName(signupRequest.getUsername()))
			{
				log.info(logMetodTitle + "user not already created by username");

			} else {
				
				log.error(logMetodTitle + "user created already by username");
				
				throw new UnSuccessfulException(UN_SUCCESSFUL_SIGNUP,USERNAME_ALREADY_USED,"user created already by username");
			}
		} else {
			
			log.error(logMetodTitle + "user created already by email");
			
			throw new UnSuccessfulException(UN_SUCCESSFUL_SIGNUP,EMAIL_ALREADY_USED,"user created already by email");
		}
		
		
		
		
		_userDto = userService.createUser(new UserCreateRequest(signupRequest.getEmail(),
				signupRequest.getUsername(),
				signupRequest.getPassword()));
		
		_user = userDtoConvertor.convert(_userDto);
		
		if(_userDto != null)
		{
			log.info(logMetodTitle + "user created succesfully");			
			
		} else {
			
			log.error(logMetodTitle + "user not created successfuly");
			
			throw new UnSuccessfulException(UN_SUCCESSFUL_SIGNUP,USER_NOT_CREATED,"user not created");
		}
		
		
		
		
		_refreshToken = refreshTokenService.saveRefreshToken(
				refreshTokenService.createRefreshToken(_user));
		
        if(_refreshToken!=null)
        {
        	log.info(logMetodTitle + "refreshToken created and saved");	
        	
        } else {
        	
        	log.error(logMetodTitle + "refreshToken not created or saved");
			
			throw new UnSuccessfulException(UN_SUCCESSFUL_SIGNUP,REFRESH_TOKEN_NOT_CREATED_OR_SAVED,"refreshToken not created or saved");
        	
        }	

        
 
        _accessToken =accessTokenService.saveAccessToken(accessTokenService.createAccessToken(_user));
        
        if(_accessToken != null)
        {
        	log.info(logMetodTitle+ "acces token created and saved");
        
        } else  {
             
        	log.error(logMetodTitle + "acces token not created and saved");
        
			throw new UnSuccessfulException(UN_SUCCESSFUL_SIGNUP,ACCESS_TOKEN_NOT_CREATED_OR_SAVED,"acces token not created and saved");
        }
        
        
        
        
        _confirmationToken = confirmationTokenService.saveConfirmationToken(
        		confirmationTokenService.createConfirmationToken(_user));
        
        if(_confirmationToken != null)
        {
        	log.info(logMetodTitle+ "confirmationToken created and saved");
        
        }
        else {
        	
        	log.error(logMetodTitle +"confirmationToken not created and saved");
        	
        	throw new UnSuccessfulException(UN_SUCCESSFUL_SIGNUP,CONFIRMATION_TOKEN_NOT_CREATED_OR_SAVED,"confirmationToken created and saved"); 
        }
		
        
        
        
        // TODO : I will send confirmation token by  email and it will be procced asyncronyous 
		
		
		// NOTE : user device platfrom checking and modifying user creating...
	
    

        
        return new SignupReponse(
				_userDto.getUserName(),
				_userDto.getEMail(),
				_accessToken,
				_refreshToken.getRefreshToken(),
				"expireTime access token",
				"expireTimeRefreshToken"
				);
   
	}

	@Override


	public RegistrationResponse register(String confirmationToken) {
		
		String logMetodTitle ="registration metod : -> ";


		/* Logic Onion
		 * 
		 * confirmation token ok
		 * confirmation token is exist ??
		 * confirmation token is valid ??
		 * confirmation token user is exist ??
		 * confirmation token update registered ??
		 * user update registered ??
		 * 
		 */
	
		
		
		if(confirmationTokenService.isExistConfirmationToken(confirmationToken))
		{
			log.info(logMetodTitle+ " confirmation token found");
			
			if(confirmationTokenService.isValidConfirmationToken(confirmationToken))
			{
				log.info(logMetodTitle + "confirmation token is valid");
		
				
			} else {
				
				log.error(logMetodTitle + "confirmation token is not valid -expired");
				
				throw new UnSuccessfulException(UN_SUCCESSFUL_REGISTRATION, CONFIRMATION_TOKEN_EXPIRED, "confirmation token is not valid -expired");
				
			}
		
		} else {
			
			log.info(logMetodTitle + "confirmation token not found");
			
			throw new UnSuccessfulException(UN_SUCCESSFUL_REGISTRATION, CONFIRMATION_TOKEN_NOT_FOUND, "confirmation token not found");
		}
		
		
		
		return null;
	}

	@Override
	public LoginRequest login(LoginRequest loginRequest) {

		/* Logic Onion
		 * 
		 * login request ok ??
		 * login request ??
		 * user exist by login request information ??
		 * already login user ??
		 * confirmation token procced ??
		 * user update registered ??
		 * 
		 */
		
		String logMetodTitle ="login metod : -> ";

		return null;
	}

	@Override
	public RefreshTokenResponse refreshToken(String refreshToken, String accessToken) {
		
		/* Logic Onion
		 * 
		 * access token ok ??
		 * refresh token ok ??
		 * access token is valid - has a user ??
		 * access token is expired ??
		 * refresh token is valid - still current and has a user ??
		 * refresh token is expired - if not return response
		 * refresh token if expired -  delete refresh token and create new refresh token 
		 * 
		 */

		
		String logMetodTitle ="refreshTokenResponse metod : -> ";

		return null;
	}

	@Override
	public LogOutResponse logout(String refreshToken) {
		
		/* Logic Onion
		 * 
		 * refresh token is valid - still current and has a user ??
		 * refresh token is expired - logout
		 * refresh token if is not expired -  delete refresh token and logout 
		 * 
		 */
		
		String logMetodTitle ="logOutResponse metod : -> ";

		return null;
	}


	

}
