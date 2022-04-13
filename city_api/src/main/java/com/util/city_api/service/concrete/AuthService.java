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
	
	 /*  IUserService 
    UserDtoConvertor userDtoConvertor,
    IRegistrationService registrationService,
    IAccessTokenService accessTokenService,
    IRefreshTokenService refreshTokenService,
    IConfirmationTokenService confirmationTokenService */

	@Override
	public SignupReponse signup(SignupRequest signupRequest) {
		
		String logMetodTitle ="signup metod : -> ";
		UserDto  _userDto;
		User _user;
		RefreshToken _refreshToken;
		ConfirmationToken _confirmationToken;
		
		
		/* LOGIC ONION
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
				
				_userDto = userService.createUser(new UserCreateRequest(signupRequest.getEmail(),signupRequest.getUsername(),signupRequest.getPassword()));
				_user = userDtoConvertor.convert(_userDto);
				
				if(_userDto != null)
				{
					log.info(logMetodTitle + "user created succesfully");
					
					_refreshToken = refreshTokenService.createRefreshToken(_user);
		            RefreshToken savedRefreshToken = refreshTokenService.saveRefreshToken(_refreshToken);
					
		            if(savedRefreshToken!=null)
		            {
		            	log.info(logMetodTitle + "refreshToken created and saved");

		            	
		            	
		            } else {
		            	
		            	log.error(logMetodTitle + "refreshToken not created or saved");
						
						throw new UnSuccessfulException(UN_SUCCESSFUL_SIGNUP,REFRESH_TOKEN_NOT_CREATED_OR_SAVED,"refreshToken not created or saved");
		            	
		            }				
					
				} else {
					
					log.error(logMetodTitle + "user not created successfuly");
					
					throw new UnSuccessfulException(UN_SUCCESSFUL_SIGNUP,USER_NOT_CREATED,"user not created");
				}
			} else {
				
				log.error(logMetodTitle + "user created already by username");
				
				throw new UnSuccessfulException(UN_SUCCESSFUL_SIGNUP,USERNAME_ALREADY_USED,"user created allready by username");
			}
		} else {
			
			log.error(logMetodTitle + "user created already by email");
			
			throw new UnSuccessfulException(UN_SUCCESSFUL_SIGNUP,EMAIL_ALREADY_USED,"user created already by email");
		}
		

		
		
		
		
		// NOTE : user device platfrom checking and modifying user creating...
		return null;
	}

	@Override


	public RegistrationResponse register(String confirmationToken) {
		
		String logMetodTitle ="registration metod : -> ";

		
		return null;
	}

	@Override
	public LoginRequest login(LoginRequest loginRequest) {

		String logMetodTitle ="login metod : -> ";

		return null;
	}

	@Override
	public RefreshTokenResponse refreshToken(String refreshToken, String accessToken) {
		
		String logMetodTitle ="refreshTokenResponse metod : -> ";

		return null;
	}

	@Override
	public LogOutResponse logout(String refreshToken) {
		
		String logMetodTitle ="logOutResponse metod : -> ";

		return null;
	}


	

}
