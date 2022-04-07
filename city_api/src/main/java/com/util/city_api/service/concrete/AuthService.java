package com.util.city_api.service.concrete;

import org.springframework.stereotype.Service;

import com.util.city_api.core.constant.CoreEnumExceptionMessages;
import com.util.city_api.core.exception.exceptionModels.UnSuccessfulException;
import com.util.city_api.product_core.dto._coreDto.UserDto;
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

@Service
@Slf4j(topic = "authService")
public class AuthService implements IAuthService{
	
	
	final private IUserService userService;
    final private IAccesTokenService accessTokenService;
    final private IRefreshTokenService refreshTokenService;
    final private IConfirmationTokenService confirmationTokenService;
	
	public AuthService(IUserService userService,
			IAccesTokenService accessTokenService,
			IRefreshTokenService refreshTokenService,
			IConfirmationTokenService confirmationTokenService)
	{
		this.userService =userService;
		this.accessTokenService = accessTokenService;
		this.refreshTokenService = refreshTokenService;
		this.confirmationTokenService = confirmationTokenService;
	}
	
	 /*  IUserService 
    UserDtoConvertor userDtoConvertor,
    IRegistrationService registrationService,
    IAccessTokenService accessTokenService,
    IRefreshTokenService refreshTokenService,
    IConfirmationTokenService confirmationTokenService */

	@Override
	public SignupReponse signup(SignupRequest signupRequest) {
		
		
		UserDto  _userDto;
		
		/* LOGIC
		 * 
		 *  request ok
		 * user created allready
		 * refresh token create
		 * accesstoken create
		 * confirm token create
		 * email send
		 * 
		 * 
		 */
		 
	
	
		if(userService.isExistUserByEmail(signupRequest.getEmail()))
		{
			log.info("user not allready created by email");
			
			if(userService.isExistUserByEmail(signupRequest.getUsername()))
			{
				log.info("user not allready created by username");
				
				_userDto = userService.createUser(new UserCreateRequest(signupRequest.getEmail(),signupRequest.getUsername(),signupRequest.getPassword()));
				
				if(_userDto != null)
				{
					log.info("user created");
					//if()
				}
			}
		} else {
			
			log.error("user created allready by email");
			
		//	throw new UnSuccessfulException(CoreEnumExceptionMessages.UN_SUCCESSFUL_CREATED_USER,"email address already used");
		}
		
		
		
		// NOTE : user device platfrom checking and modifying user creating...
		return null;
	}

	@Override


	public RegistrationResponse register(String confirmationToken) {
		return null;
	}

	@Override
	public LoginRequest login(LoginRequest loginRequest) {
		return null;
	}

	@Override
	public RefreshTokenResponse refreshToken(String refreshToken, String accessToken) {
		return null;
	}

	@Override
	public LogOutResponse logout(String refreshToken) {
		return null;
	}


	

}
