package com.util.city_api.service.concrete;

import org.springframework.stereotype.Service;

import com.util.city_api.core.exception.exceptionModels.UnSuccessfulException;
import com.util.city_api.entity.primary.User;
import com.util.city_api.entity.security.ConfirmationToken;
import com.util.city_api.entity.security.RefreshToken;
import com.util.city_api.product_core.dto.primaryDto.UserDto;
import com.util.city_api.product_core.dtoConvertor.UserDtoConvertor;
import com.util.city_api.product_core.request.createRequest.LoginRequest;
import com.util.city_api.product_core.request.createRequest.ResetPasswordRequest;
import com.util.city_api.product_core.request.createRequest.SignupRequest;
import com.util.city_api.product_core.request.createRequest.UserCreateRequest;
import com.util.city_api.product_core.response.LogoutResponse;
import com.util.city_api.product_core.response.LoginResponse;
import com.util.city_api.product_core.response.RefreshTokenResponse;
import com.util.city_api.product_core.response.RegistrationResponse;
import com.util.city_api.product_core.response.ResetPasswordResponse;
import com.util.city_api.product_core.response.SignupReponse;
import com.util.city_api.service._abstract.IAccesTokenService;
import com.util.city_api.service._abstract.IAuthService;
import com.util.city_api.service._abstract.IConfirmationTokenService;
import com.util.city_api.service._abstract.IRefreshTokenService;
import com.util.city_api.service._abstract.IUserService;

import lombok.extern.slf4j.Slf4j;

import static com.util.city_api.core.constant.CoreConstantExceptionErrorCode.*;
import static com.util.city_api.core.constant.CoreEnumExceptionMessages.*;

import java.time.LocalDateTime;

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
				
				throw new UnSuccessfulException(UN_SUCCESSFUL_SIGNUP,D_USERNAME_ALREADY_USED,"user created already by username");
			}
		} else {
			
			log.error(logMetodTitle + "user created already by email");
			
			throw new UnSuccessfulException(UN_SUCCESSFUL_SIGNUP,D_EMAIL_ALREADY_USED,"user created already by email");
		}
		
		
		
		
		_userDto = userService.createUser(new UserCreateRequest(
				signupRequest.getUsername(),
				signupRequest.getEmail(),
				signupRequest.getPassword()));
		
		_user = userDtoConvertor.convert(_userDto);
		
		if(_userDto != null)
		{
			log.info(logMetodTitle + "user created succesfully");			
			
		} else {
			
			log.error(logMetodTitle + "user not created successfuly");
			
			throw new UnSuccessfulException(UN_SUCCESSFUL_SIGNUP,D_USER_NOT_CREATED,"user not created");
		}
		
		
		
		
		_refreshToken = refreshTokenService.saveRefreshToken(
				refreshTokenService.createRefreshToken(_user));
		
        if(_refreshToken!=null)
        {
        	log.info(logMetodTitle + "refreshToken created and saved");	
        	
        } else {
        	
        	log.error(logMetodTitle + "refreshToken not created or saved");
			
			throw new UnSuccessfulException(UN_SUCCESSFUL_SIGNUP,D_REFRESH_TOKEN_NOT_CREATED_OR_SAVED,"refreshToken not created or saved");
        	
        }	

        
 
        _accessToken =accessTokenService.saveAccessToken(accessTokenService.createAccessToken(_user));
        
        if(_accessToken != null)
        {
        	log.info(logMetodTitle+ "acces token created and saved");
        
        } else  {
             
        	log.error(logMetodTitle + "acces token not created and saved");
        
			throw new UnSuccessfulException(UN_SUCCESSFUL_SIGNUP,D_ACCESS_TOKEN_NOT_CREATED_OR_SAVED,"acces token not created and saved");
        }
        
        
        
        
        _confirmationToken = confirmationTokenService.saveConfirmationToken(
        		confirmationTokenService.createConfirmationToken(_user));
        
        if(_confirmationToken != null)
        {
        	log.info(logMetodTitle+ "confirmationToken created and saved");
        
        }
        else {
        	
        	log.error(logMetodTitle +"confirmationToken not created and saved");
        	
        	throw new UnSuccessfulException(UN_SUCCESSFUL_SIGNUP,D_CONFIRMATION_TOKEN_NOT_CREATED_OR_SAVED,"confirmationToken not created and saved"); 
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
		
		String logMetodTitle ="register metod : -> ";
		User _user = null;
		ConfirmationToken _confirmationToken = null;

		
		/* Logic Onion
		 * 
		 * confirmation token ok
		 * confirmation token is exist ??
		 * confirmation token is valid -is expired or -is already used ??
		 * is user registered already ??
		 * confirmation token update registered ??
		 * user update registered ??
		 * 
		 */
	
		
		
		_confirmationToken = confirmationTokenService.getConfirmationTokenByConfirmationToken(confirmationToken);
		
		if(_confirmationToken != null)
		{
			log.info(logMetodTitle+ " confirmation token found");
			
			if(confirmationTokenService.isExpiredConfirmationToken(confirmationToken))
			{
				log.info(logMetodTitle + "confirmation token is valid - not yet expired");
				
				if(confirmationTokenService.isAlreadyUsed(confirmationToken))
				{
					
					log.info(logMetodTitle +  "confirmation token is valid - not used already");
					
				} else {
					
					log.error(logMetodTitle + "confirmation token used already");
					
					throw new UnSuccessfulException(UN_SUCCESSFUL_REGISTRATION, D_CONFIRMATION_TOKEN_ALREADY_USED, "confirmation token is not valid -already used");
					
				}
		
				
			} else {
				
				log.error(logMetodTitle + "confirmation token is not valid -expired");
				
				throw new UnSuccessfulException(UN_SUCCESSFUL_REGISTRATION, D_CONFIRMATION_TOKEN_EXPIRED, "confirmation token is not valid -expired");
				
			}
		
		} else {
			
			log.error(logMetodTitle + "confirmation token not found");
			
			throw new UnSuccessfulException(UN_SUCCESSFUL_REGISTRATION, D_CONFIRMATION_TOKEN_NOT_FOUND, "confirmation token not found");
		}
		
		
		_user = _confirmationToken.getUser();
		
		if(!_user.getIsRegistered())
		{
			
			log.info(logMetodTitle + "user is not registered already");
			
			if(userService.updateRegisteredUser(_user))
			{
				
				log.info(logMetodTitle + "user registered succesfully");
				 
				if(confirmationTokenService.updateRegisteredConfirmationToken(_confirmationToken))
				{
					
					log.info(logMetodTitle + "confirmation token is registered succesfully");

					
				} else {
					
					log.error(logMetodTitle + "confirmation token is not registered succesfully");
				
				   throw new UnSuccessfulException(UN_SUCCESSFUL_REGISTRATION, D_CONFIRMATION_TOKEN_NOT_REGISTERED, "confirmation token is not registered succesfully"); 
					
				}
				
			} else {
				
				log.error(logMetodTitle + "user is not registered succesfully");
				
				throw new UnSuccessfulException(UN_SUCCESSFUL_REGISTRATION, D_USER_NOT_REGISTERED, "user is not registered succesfully");

			}
			
		} else {
			
			log.error(logMetodTitle + "user is registered already");
			
			throw new UnSuccessfulException(UN_SUCCESSFUL_REGISTRATION, D_USER_ALREADY_REGISTERED, "user is registered already");
			
		}
		
		
		return new RegistrationResponse(
				"user registry is  success !!!",
				_user.getEMail(),
				_user.getUserName(),
				LocalDateTime.now()
				);
	}

	@Override
	public LoginResponse login(LoginRequest loginRequest) {

		String logMetodTitle ="login metod : -> ";
		UserDto  _userDto =null;
		User _user = null;
		String _accessToken = null;
		RefreshToken _refreshToken = null;
		
		/* Logic Onion
		 * 
		 * login request ok ??
		 * user is exist ??
		 * user is active ??
		 * user is already login ??
		 * refresh token create  and save ??
		 * access token create and save ??
		 * 
		 */
		
		
		
		_userDto = userService.getUserByUserName(loginRequest.getUserName());
		
		if(_userDto != null)
		{
			
			log.info(logMetodTitle + "user found by username");
			
			if(_userDto.getIsActive())
			{
				
				log.info(logMetodTitle + "user is active");
				
			} else {
				
				log.error(logMetodTitle + "user is not active");
				
				throw new UnSuccessfulException(UN_SUCCESSFUL_LOGIN, D_USER_NOT_ACTIVE, "user is not active");
			}
			
		} else {
			
			log.error(logMetodTitle + "user not found by username");
			
			throw new UnSuccessfulException(UN_SUCCESSFUL_LOGIN, D_USER_NOT_FOUND, "user not found by username");
			
		}
		
		
		_user = userDtoConvertor.convert(_userDto);
		_refreshToken = refreshTokenService.getRefreshTokenByUser(_user);

		if(_refreshToken == null)
		{			
			log.info(logMetodTitle + "user not already login");
		
			_refreshToken =refreshTokenService.saveRefreshToken(
					refreshTokenService.createRefreshToken(_user));
			
			if(_refreshToken != null)
			{
				
				log.info(logMetodTitle + "refresh token created and saved succesfully");
				
			} else {
				
				log.error(logMetodTitle + "refresh token not created or saved succesfully");
				
				throw new UnSuccessfulException(UN_SUCCESSFUL_LOGIN, D_REFRESH_TOKEN_NOT_CREATED_OR_SAVED, "refresh token not created succesfully");

			}
			
		} else {
			
			log.error(logMetodTitle + "user already login");
			
			throw new UnSuccessfulException(UN_SUCCESSFUL_LOGIN, D_USER_ALREADY_LOGIN, "user already login");
			
		}
		
		
		  _accessToken =accessTokenService.saveAccessToken(accessTokenService.createAccessToken(_user));
		
		  if(_accessToken != null)
		  {
			  
			  log.info(logMetodTitle + "access token created and saved successfully");
		
	   	  } else {
			
			log.error(logMetodTitle + "access token not created and saved successfully");
		
			throw new UnSuccessfulException(UN_SUCCESSFUL_LOGIN, D_ACCESS_TOKEN_NOT_CREATED_OR_SAVED, "access token not created and saved successfully");
	
		  }
		  
		  
		
		return new LoginResponse(
				_userDto.getUserId(),
	            _userDto.getUserName(),
	            _userDto.getEMail(),
	            _userDto.getIsActive(),
	            _userDto.getIsRegistered(),
	            _userDto.getRoles(),
	            LocalDateTime.now(),
	            null,
	            _accessToken,
	            _refreshToken.getRefreshToken()
				);
	}

	@Override
	public RefreshTokenResponse refreshToken(String refreshToken, String accessToken) {
		
		String logMetodTitle ="refreshToken metod : -> ";
		UserDto  _userDto =null;
		User _user = null;
		String _accessToken = null;
		RefreshToken _refreshToken = null;
		
		/* Logic Onion
		 * 
		 * access token ok ??
		 * access token is not still valid ??
		 * refresh token ok ??
		 * refresh token is still valid ??
		 * refresh token if not still valid -  delete refresh token 
		 * access token create and save
		 * 
		 */
		
		
		if(accessTokenService.getAccessTokenByAccessToken(accessToken) != null) 
		{
			
			log.info(logMetodTitle + "access token found");
			
			if(!accessTokenService.verifyAccessToken(accessToken)) 
			{
				
				log.info(logMetodTitle + "accesss token is not valid");
				
				
			} else {
								
                log.error(logMetodTitle + "access token is still valid");
				
				throw new UnSuccessfulException(UN_SUCCESSFUL_RENEW_REFRESH_TOKEN, D_ACCESS_TOKEN_STILL_VALID, "access still valid");
			}
			
			
		} else {
			
			
			log.info(logMetodTitle + "access token not found");
		
		}

		
		
		_refreshToken = refreshTokenService.getRefreshTokenByRefreshToken(refreshToken);
		
		if(_refreshToken != null)
		{
			
			log.info(logMetodTitle + " refresh token found"); 
		
			if(refreshTokenService.verifyRefreshToken(_refreshToken.getRefreshToken()))
			{
				log.info(logMetodTitle + "refresh token is valid");
				
				_user = _refreshToken.getUser();
				
			String createdAccessToken =	accessTokenService.createAccessToken(_user);
			
			return new RefreshTokenResponse(
					_refreshToken.getRefreshToken(),
					createdAccessToken
					);
					
				
			} else {
				
				log.error(logMetodTitle + "refresh token is not valid");
				
				refreshTokenService.deleteRefreshTokenByRefreshToken(_refreshToken);
				
				log.info(logMetodTitle + "refresh token deleted");
				
				throw new UnSuccessfulException(UN_SUCCESSFUL_RENEW_REFRESH_TOKEN, D_REFRESH_TOKEN_NOT_VALID, "refresh token is not valid");
			}
		
		} else {
			
			log.error(logMetodTitle + "refresh token not found");
			
			throw new UnSuccessfulException(UN_SUCCESSFUL_RENEW_REFRESH_TOKEN, D_REFRESH_TOKEN_NOT_FOUND, "refresh token not found");
		
		}
		
	}

	@Override
	public LogoutResponse logout(String refreshToken) {
		
		String logMetodTitle ="logoutResponse metod : -> ";
		RefreshToken _refreshToken = null;
		
		/* Logic Onion
		 * 
		 * refresh token ok ??
		 * refresh token is exist - delete??
		 * 
		 */
		
		
		_refreshToken = refreshTokenService.getRefreshTokenByRefreshToken(refreshToken);
		
		if(_refreshToken != null)
		{
			log.info(logMetodTitle + " refresh token found");
			
			return new LogoutResponse("true");

			
		} else {
			
			log.error(logMetodTitle + " refresh token not found");
			
			return new LogoutResponse("true");

		}

	}

	@Override
	public ResetPasswordResponse resetPassword(ResetPasswordRequest resetPasswordRequest) {
		
		String logMetodTitle ="resetPassword metod : -> ";
		RefreshToken _refreshToken = null;
		
		/* Logic Onion
		 * 
		 * 
		 */
		return null;
	}

	

}
