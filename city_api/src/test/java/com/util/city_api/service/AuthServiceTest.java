package com.util.city_api.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import com.util.city_api.core.exception.abstracts.BaseExceptionModel;
import com.util.city_api.core.exception.exceptionModels.UnSuccessfulException;
import com.util.city_api.product_core.request.createRequest.UserCreateRequest;
import com.util.city_api.product_core.response.LoginResponse;
import com.util.city_api.product_core.response.RefreshTokenResponse;
import com.util.city_api.product_core.response.RegistrationResponse;
import com.util.city_api.product_core.response.SignupReponse;
import com.util.city_api.service.concrete.AuthService;
import com.util.city_api.service.mockWorkbench.AuthServiceTestWorkBench;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import static com.util.city_api.core.constant.CoreConstantExceptionErrorCode.*;
import static com.util.city_api.core.constant.CoreEnumExceptionMessages.*;

public class AuthServiceTest extends AuthServiceTestWorkBench{
		
   	   //singup metod logic...
	/*	
	 *  
	 * request ok ??
	 * user created allready by email or username ??
	 * refresh token create ?? 
	 * accesstoken create ??
	 * confirm token create ??
	 * email send ??
	 * 
	 * NOTE : user device platfrom checking and modifying user creating...
	 */
	
	     // signup metod :
	@Test
	void Signup_WhenUserAlReadyCreatedByEmailThenItMustThrowUnSuccessFulException() {

		authService = new AuthService(mockUserService,
				mockAccessTokenService,
				mockRefreshTokenService,
				mockConfirmationTokenService,
				mockUserDtoConvertor);
		
     	when(mockUserService.isExistUserByEmail(signupRequestModel.getEmail())).thenReturn(true);
		
     	BaseExceptionModel  exceptionModel = Assertions.assertThrows(UnSuccessfulException.class,()->{
		
     		authService.signup(signupRequestModel);
	});

    assertEquals(exceptionModel.getErrorMessage(),UN_SUCCESSFUL_SIGNUP.getExceptionMessage());
	assertEquals(exceptionModel.getErrorCode(), B_UN_SUCCESSFUL_EXCEPTION_ERROR_CODE + T_SIGNUP + D_EMAIL_ALREADY_USED);
	
	} 

	@Test
	void Signup_WhenUserAlReadyCreatedByUsernameThenItMustThrowUnSuccessFulException() {

		authService = new AuthService(mockUserService, 
				mockAccessTokenService,
				mockRefreshTokenService,
				mockConfirmationTokenService,
				mockUserDtoConvertor);
		
     	when(mockUserService.isExistUserByEmail(signupRequestModel.getEmail())).thenReturn(false);
     	when(mockUserService.isExistUserByUserName(signupRequestModel.getUsername())).thenReturn(true);
		
     	BaseExceptionModel  exceptionModel = Assertions.assertThrows(UnSuccessfulException.class,()->{
		
     		authService.signup(signupRequestModel);
	});

    assertEquals(exceptionModel.getErrorMessage(),UN_SUCCESSFUL_SIGNUP.getExceptionMessage());
	assertEquals(exceptionModel.getErrorCode(), B_UN_SUCCESSFUL_EXCEPTION_ERROR_CODE + T_SIGNUP + D_USERNAME_ALREADY_USED);
	
	}
	
	@Test
	void Signup_WhenUserNotCreatedSuccessfullyThenItMustThrowUnSuccessFulException() {
		
		authService = new AuthService(mockUserService,
				mockAccessTokenService,
				mockRefreshTokenService,
				mockConfirmationTokenService,
				mockUserDtoConvertor);
		
     	when(mockUserService.isExistUserByEmail(signupRequestModel.getEmail())).thenReturn(false);
     	when(mockUserService.isExistUserByUserName(signupRequestModel.getUsername())).thenReturn(false);
     	when(mockUserService.createUser(userCreateRequestModel)).thenReturn(userDtoModel);
		
     	BaseExceptionModel  exceptionModel = Assertions.assertThrows(UnSuccessfulException.class,()->{
		
     		authService.signup(signupRequestModel);
	});

    assertEquals(exceptionModel.getErrorMessage(),UN_SUCCESSFUL_SIGNUP.getExceptionMessage());
	assertEquals(exceptionModel.getErrorCode(), B_UN_SUCCESSFUL_EXCEPTION_ERROR_CODE + T_SIGNUP + D_USER_NOT_CREATED);
	}
	
	@Test
	void Signup_WhenRefreshTokenNotCreatedSuccessfullyThenItMustThrowUnSuccessFulException() {
		
		authService = new AuthService(mockUserService,
				mockAccessTokenService,
				mockRefreshTokenService,
				mockConfirmationTokenService,
				mockUserDtoConvertor);
		
     	when(mockUserService.isExistUserByEmail(signupRequestModel.getEmail())).thenReturn(false);
     	when(mockUserService.isExistUserByUserName(signupRequestModel.getUsername())).thenReturn(false);
     	when(mockUserService.createUser(new UserCreateRequest(signupRequestModel.getEmail(),
     			signupRequestModel.getUsername(),
     			signupRequestModel.getPassword()))).thenReturn(userDtoModel);
		when(mockRefreshTokenService.createRefreshToken(userModel)).thenReturn(null);
		
     	BaseExceptionModel  exceptionModel = Assertions.assertThrows(UnSuccessfulException.class,()->{
		
     		authService.signup(signupRequestModel);
	});

    assertEquals(exceptionModel.getErrorMessage(),UN_SUCCESSFUL_SIGNUP.getExceptionMessage());
	assertEquals(exceptionModel.getErrorCode(), B_UN_SUCCESSFUL_EXCEPTION_ERROR_CODE + T_SIGNUP + D_REFRESH_TOKEN_NOT_CREATED_OR_SAVED);
	}
	
	@Test
	void Signup_WhenRefreshTokenNotSavedSuccessfullyThenItMustThrowUnSuccessFulException() {
		
		authService = new AuthService(mockUserService,
				mockAccessTokenService,
				mockRefreshTokenService,
				mockConfirmationTokenService,
				mockUserDtoConvertor);
		
     	when(mockUserService.isExistUserByEmail(signupRequestModel.getEmail())).thenReturn(false);
     	when(mockUserService.isExistUserByUserName(signupRequestModel.getUsername())).thenReturn(false);
     	when(mockUserService.createUser(new UserCreateRequest(signupRequestModel.getEmail(),signupRequestModel.getUsername(),signupRequestModel.getPassword()))).thenReturn(userDtoModel);
		when(mockUserDtoConvertor.convert(userDtoModel)).thenReturn(userModel);
     	when(mockRefreshTokenService.createRefreshToken(userModel)).thenReturn(refreshTokenModel);
		when(mockRefreshTokenService.saveRefreshToken(refreshTokenModel)).thenReturn(null);
		
     	BaseExceptionModel  exceptionModel = Assertions.assertThrows(UnSuccessfulException.class,()->{
		
     		authService.signup(signupRequestModel);
	});

    assertEquals(exceptionModel.getErrorMessage(),UN_SUCCESSFUL_SIGNUP.getExceptionMessage());
	assertEquals(exceptionModel.getErrorCode(), B_UN_SUCCESSFUL_EXCEPTION_ERROR_CODE + T_SIGNUP + D_REFRESH_TOKEN_NOT_CREATED_OR_SAVED);
	}
	
	@Test
	void Signup_WhenAccessTokenNotCreatedSuccessfullyThenItMustThrowUnSuccessFulException() {
		
		authService = new AuthService(mockUserService,
				mockAccessTokenService,
				mockRefreshTokenService,
				mockConfirmationTokenService,
				mockUserDtoConvertor);
		
     	when(mockUserService.isExistUserByEmail(signupRequestModel.getEmail())).thenReturn(false);
     	when(mockUserService.isExistUserByUserName(signupRequestModel.getUsername())).thenReturn(false);
     	when(mockUserService.createUser(new UserCreateRequest(signupRequestModel.getEmail(),signupRequestModel.getUsername(),signupRequestModel.getPassword()))).thenReturn(userDtoModel);
		when(mockUserDtoConvertor.convert(userDtoModel)).thenReturn(userModel);
     	when(mockRefreshTokenService.createRefreshToken(userModel)).thenReturn(refreshTokenModel);
		when(mockRefreshTokenService.saveRefreshToken(refreshTokenModel)).thenReturn(refreshTokenModel);
		when(mockAccessTokenService.createAccessToken(userModel)).thenReturn(accesToken);
		
     	BaseExceptionModel  exceptionModel = Assertions.assertThrows(UnSuccessfulException.class,()->{
		
     		authService.signup(signupRequestModel);
	});

    assertEquals(exceptionModel.getErrorMessage(),UN_SUCCESSFUL_SIGNUP.getExceptionMessage());
	assertEquals(exceptionModel.getErrorCode(), B_UN_SUCCESSFUL_EXCEPTION_ERROR_CODE + T_SIGNUP + D_ACCESS_TOKEN_NOT_CREATED_OR_SAVED);
	}
	
	@Test
	void Signup_WhenAccessTokenNotSavedSuccessfullyThenItMustThrowUnSuccessFulException() {
		
		authService = new AuthService(mockUserService,
				mockAccessTokenService,
				mockRefreshTokenService,
				mockConfirmationTokenService,
				mockUserDtoConvertor);
		
     	when(mockUserService.isExistUserByEmail(signupRequestModel.getEmail())).thenReturn(false);
     	when(mockUserService.isExistUserByUserName(signupRequestModel.getUsername())).thenReturn(false);
     	when(mockUserService.createUser(new UserCreateRequest(signupRequestModel.getEmail(),signupRequestModel.getUsername(),signupRequestModel.getPassword()))).thenReturn(userDtoModel);
		when(mockUserDtoConvertor.convert(userDtoModel)).thenReturn(userModel);
     	when(mockRefreshTokenService.createRefreshToken(userModel)).thenReturn(refreshTokenModel);
		when(mockRefreshTokenService.saveRefreshToken(refreshTokenModel)).thenReturn(refreshTokenModel);
		when(mockAccessTokenService.createAccessToken(userModel)).thenReturn(accesToken);
		when(mockAccessTokenService.saveAccessToken(accesToken)).thenReturn(null);

		
     	BaseExceptionModel  exceptionModel = Assertions.assertThrows(UnSuccessfulException.class,()->{
		
     		authService.signup(signupRequestModel);
	});

    assertEquals(exceptionModel.getErrorMessage(), UN_SUCCESSFUL_SIGNUP.getExceptionMessage());
	assertEquals(exceptionModel.getErrorCode(), B_UN_SUCCESSFUL_EXCEPTION_ERROR_CODE + T_SIGNUP + D_ACCESS_TOKEN_NOT_CREATED_OR_SAVED);
	}

	void Signup_WhenSignupSuccesfullyThenItMustReturnSignupResponseThatContainsSameInformationWithSignupRequest() {
		
		authService = new AuthService(mockUserService,
				mockAccessTokenService,
				mockRefreshTokenService,
				mockConfirmationTokenService,
				mockUserDtoConvertor);
		
     	when(mockUserService.isExistUserByEmail(signupRequestModel.getEmail())).thenReturn(false);
     	when(mockUserService.isExistUserByUserName(signupRequestModel.getUsername())).thenReturn(false);
     	when(mockUserService.createUser(new UserCreateRequest(signupRequestModel.getEmail(),signupRequestModel.getUsername(),signupRequestModel.getPassword()))).thenReturn(userDtoModel);
		when(mockUserDtoConvertor.convert(userDtoModel)).thenReturn(userModel);
     	when(mockRefreshTokenService.createRefreshToken(userModel)).thenReturn(refreshTokenModel);
		when(mockRefreshTokenService.saveRefreshToken(refreshTokenModel)).thenReturn(refreshTokenModel);
		when(mockAccessTokenService.createAccessToken(userModel)).thenReturn(accesToken);
		when(mockAccessTokenService.saveAccessToken(accesToken)).thenReturn(accesToken);
		
     	SignupReponse signupReponse =	authService.signup(signupRequestModel);

    assertEquals(signupReponse.getUsername(),signupRequestModel.getUsername());
    assertEquals(signupReponse.getEmail(),signupRequestModel.getEmail());
    assertNotNull(signupReponse.getRefreshToken());
	}

	
	
	
	   //register metod logic...
	/*
	 *  
     * confirmation token ok
	 * confirmation token is exist ??
     * confirmation token is valid -is expired or -is already used ??
	 * is user registered already ??
	 * confirmation token update registered ??
	 * user update registered ??
	 * 
	 */
	
	
	     // register metod :
	@Test
	void Register_WhenConfirmationTokenIsNotExıstThenItMustThrowUnSuccessFulException() {

		authService = new AuthService(mockUserService,
				mockAccessTokenService,
				mockRefreshTokenService,
				mockConfirmationTokenService,
				mockUserDtoConvertor);
		
     	when(mockConfirmationTokenService.getConfirmationTokenByConfirmationToken(confirmationTokenRequestModel)).thenReturn(null);

     	BaseExceptionModel  exceptionModel = Assertions.assertThrows(UnSuccessfulException.class,()->{
    		
     		authService.register(confirmationTokenRequestModel);
	});

    assertEquals(exceptionModel.getErrorMessage(),UN_SUCCESSFUL_REGISTRATION.getExceptionMessage());
	assertEquals(exceptionModel.getErrorCode(), B_UN_SUCCESSFUL_EXCEPTION_ERROR_CODE + T_REGISTRATION + D_CONFIRMATION_TOKEN_NOT_FOUND);
	
	}
	
	@Test
	void Register_WhenConfirmationTokenIsExpiredThenItMustThrowUnSuccessFulException() {

		authService = new AuthService(mockUserService,
				mockAccessTokenService,
				mockRefreshTokenService,
				mockConfirmationTokenService,
				mockUserDtoConvertor);
		
     	when(mockConfirmationTokenService.getConfirmationTokenByConfirmationToken(confirmationTokenRequestModel)).thenReturn(confirmationToken);
     	when(mockConfirmationTokenService.isExpiredConfirmationToken(confirmationTokenRequestModel)).thenReturn(false);

     	
     	BaseExceptionModel  exceptionModel = Assertions.assertThrows(UnSuccessfulException.class,()->{
    		
     		authService.register(confirmationTokenRequestModel);
	});

    assertEquals(exceptionModel.getErrorMessage(),UN_SUCCESSFUL_REGISTRATION.getExceptionMessage());
	assertEquals(exceptionModel.getErrorCode(), B_UN_SUCCESSFUL_EXCEPTION_ERROR_CODE + T_REGISTRATION + D_CONFIRMATION_TOKEN_EXPIRED);
	
	}

	@Test
	void Register_WhenConfirmationTokenIsAlreadyUsedThenItMustThrowUnSuccessFulException() {

		authService = new AuthService(mockUserService,
				mockAccessTokenService,
				mockRefreshTokenService,
				mockConfirmationTokenService,
				mockUserDtoConvertor);
		
     	when(mockConfirmationTokenService.getConfirmationTokenByConfirmationToken(confirmationTokenRequestModel)).thenReturn(confirmationToken);
     	when(mockConfirmationTokenService.isExpiredConfirmationToken(confirmationTokenRequestModel)).thenReturn(true);
     	when(mockConfirmationTokenService.isAlreadyUsed(confirmationTokenRequestModel)).thenReturn(false);

     	
     	BaseExceptionModel  exceptionModel = Assertions.assertThrows(UnSuccessfulException.class,()->{
    		
     		authService.register(confirmationTokenRequestModel);
	});

    assertEquals(exceptionModel.getErrorMessage(),UN_SUCCESSFUL_REGISTRATION.getExceptionMessage());
	assertEquals(exceptionModel.getErrorCode(), B_UN_SUCCESSFUL_EXCEPTION_ERROR_CODE + T_REGISTRATION + D_CONFIRMATION_TOKEN_ALREADY_USED);
	
	}
	
	@Test
	void Register_WhenUserAlreadyRegisteredThenItMustThrowUnSuccessFulException() {

		authService = new AuthService(mockUserService,
				mockAccessTokenService,
				mockRefreshTokenService,
				mockConfirmationTokenService,
				mockUserDtoConvertor);
		
     	when(mockConfirmationTokenService.getConfirmationTokenByConfirmationToken(confirmationTokenRequestModel)).thenReturn(confirmationToken);
     	when(mockConfirmationTokenService.isExpiredConfirmationToken(confirmationTokenRequestModel)).thenReturn(true);
     	when(mockConfirmationTokenService.isAlreadyUsed(confirmationTokenRequestModel)).thenReturn(true);
     	when(mockUserModel.getIsRegistered()).thenReturn(true);

     	
     	BaseExceptionModel  exceptionModel = Assertions.assertThrows(UnSuccessfulException.class,()->{
    		
     		authService.register(confirmationTokenRequestModel);
	});

    assertEquals(exceptionModel.getErrorMessage(),UN_SUCCESSFUL_REGISTRATION.getExceptionMessage());
	assertEquals(exceptionModel.getErrorCode(), B_UN_SUCCESSFUL_EXCEPTION_ERROR_CODE + T_REGISTRATION + D_USER_ALREADY_REGISTERED);
	
	}
	
	@Test
	void Register_WhenUserNotUptadedRegisteredThenItMustThrowUnSuccessFulException() {

		authService = new AuthService(mockUserService,
				mockAccessTokenService,
				mockRefreshTokenService,
				mockConfirmationTokenService,
				mockUserDtoConvertor);
		
     	when(mockConfirmationTokenService.getConfirmationTokenByConfirmationToken(confirmationTokenRequestModel)).thenReturn(confirmationToken);
     	when(mockConfirmationTokenService.isExpiredConfirmationToken(confirmationTokenRequestModel)).thenReturn(true);
     	when(mockConfirmationTokenService.isAlreadyUsed(confirmationTokenRequestModel)).thenReturn(true);
     	when(mockUserModel.getIsRegistered()).thenReturn(false);
     	when(mockUserService.updateRegisteredUser(mockUserModel)).thenReturn(false);

     	
     	BaseExceptionModel  exceptionModel = Assertions.assertThrows(UnSuccessfulException.class,()->{
    		
     		authService.register(confirmationTokenRequestModel);
	});

    assertEquals(exceptionModel.getErrorMessage(),UN_SUCCESSFUL_REGISTRATION.getExceptionMessage());
	assertEquals(exceptionModel.getErrorCode(), B_UN_SUCCESSFUL_EXCEPTION_ERROR_CODE + T_REGISTRATION + D_USER_NOT_REGISTERED);
	
	}
	
	@Test
	void Register_WhenConfirmationTokenNotUptadedRegisteredThenItMustThrowUnSuccessFulException() {

		authService = new AuthService(mockUserService,
				mockAccessTokenService,
				mockRefreshTokenService,
				mockConfirmationTokenService,
				mockUserDtoConvertor);
		
     	when(mockConfirmationTokenService.getConfirmationTokenByConfirmationToken(confirmationTokenRequestModel)).thenReturn(confirmationToken);
     	when(mockConfirmationTokenService.isExpiredConfirmationToken(confirmationTokenRequestModel)).thenReturn(true);
     	when(mockConfirmationTokenService.isAlreadyUsed(confirmationTokenRequestModel)).thenReturn(true);
     	when(mockUserModel.getIsRegistered()).thenReturn(false);
     	when(mockUserService.updateRegisteredUser(mockUserModel)).thenReturn(true);
     	when(mockConfirmationTokenService.updateRegisteredConfirmationToken(confirmationToken)).thenReturn(false);
     	
     	BaseExceptionModel  exceptionModel = Assertions.assertThrows(UnSuccessfulException.class,()->{
    		
     		authService.register(confirmationTokenRequestModel);
	});

    assertEquals(exceptionModel.getErrorMessage(),UN_SUCCESSFUL_REGISTRATION.getExceptionMessage());
	assertEquals(exceptionModel.getErrorCode(), B_UN_SUCCESSFUL_EXCEPTION_ERROR_CODE + T_REGISTRATION + D_CONFIRMATION_TOKEN_NOT_REGISTERED);
	
	}
	
	@Test
	void Register_WhenRegisterSuccessfullyThenItMustReturnRegistrationResponseThatContainsAboutRegistrationKnowledge() {

		authService = new AuthService(mockUserService,
				mockAccessTokenService,
				mockRefreshTokenService,
				mockConfirmationTokenService,
				mockUserDtoConvertor);
		
     	when(mockConfirmationTokenService.getConfirmationTokenByConfirmationToken(confirmationTokenRequestModel)).thenReturn(confirmationToken);
     	when(mockConfirmationTokenService.isExpiredConfirmationToken(confirmationTokenRequestModel)).thenReturn(true);
     	when(mockConfirmationTokenService.isAlreadyUsed(confirmationTokenRequestModel)).thenReturn(true);
     	when(mockUserModel.getIsRegistered()).thenReturn(false);
     	when(mockUserService.updateRegisteredUser(mockUserModel)).thenReturn(true);
     	when(mockConfirmationTokenService.updateRegisteredConfirmationToken(confirmationToken)).thenReturn(true);
     	when(mockUserModel.getEMail()).thenReturn("email@email");
     	when(mockUserModel.getUserName()).thenReturn("userName");

     
     	RegistrationResponse registrationResponseReturned = authService.register(confirmationTokenRequestModel);
	
     	assertEquals(registrationResponseReturned.getEmail(), "email@email");
     	assertEquals(registrationResponseReturned.getUserName(), "userName");
     	assertNotNull(registrationResponseReturned.getRegistredAt());
     	
	}

	
	
        //login metod logic...
	 /* 
	  * 
	  * login request ok ??
	  * user is exist ??
	  * user is active ??
	  * user is already login ??
	  * refresh token create  and save ??
	  * access token create and save ??
	  * 
	  */
	
	@Test
	 void Login_WhenUserNotFoundByLoginRequestInformationThenItMustThrowUnSuccessFulException() {

			authService = new AuthService(mockUserService,
					mockAccessTokenService,
					mockRefreshTokenService,
					mockConfirmationTokenService,
					mockUserDtoConvertor);
			
	     	when(mockUserService.getUserByUserName(loginRequestModel.getUserName())).thenReturn(null);
	     	
	     	BaseExceptionModel  exceptionModel = Assertions.assertThrows(UnSuccessfulException.class,()->{
	    		
	     		authService.login(loginRequestModel);
		});

	    assertEquals(exceptionModel.getErrorMessage(),UN_SUCCESSFUL_LOGIN.getExceptionMessage());
		assertEquals(exceptionModel.getErrorCode(), B_UN_SUCCESSFUL_EXCEPTION_ERROR_CODE + T_LOGIN + D_USER_NOT_FOUND);
		 
	 }
	
	@Test
	 void Login_WhenUserNotActiveThenItMustThrowUnSuccessFulException() {

			authService = new AuthService(mockUserService,
					mockAccessTokenService,
					mockRefreshTokenService,
					mockConfirmationTokenService,
					mockUserDtoConvertor);
			
	     	when(mockUserService.getUserByUserName(loginRequestModel.getUserName())).thenReturn(mockUserDtoModel);
	     	when(mockUserDtoModel.getIsActive()).thenReturn(false);
	     	
	     	BaseExceptionModel  exceptionModel = Assertions.assertThrows(UnSuccessfulException.class,()->{
	    		
	     		authService.login(loginRequestModel);
		});

	    assertEquals(exceptionModel.getErrorMessage(),UN_SUCCESSFUL_LOGIN.getExceptionMessage());
		assertEquals(exceptionModel.getErrorCode(), B_UN_SUCCESSFUL_EXCEPTION_ERROR_CODE + T_LOGIN + D_USER_NOT_ACTIVE);
		 
	 }

	@Test
	 void Login_WhenUserAlreadyLoginThenItMustThrowUnSuccessFulException() {

			authService = new AuthService(mockUserService,
					mockAccessTokenService,
					mockRefreshTokenService,
					mockConfirmationTokenService,
					mockUserDtoConvertor);
			
	     	when(mockUserService.getUserByUserName(loginRequestModel.getUserName())).thenReturn(mockUserDtoModel);
	     	when(mockUserDtoModel.getIsActive()).thenReturn(true);
	     	when(mockUserDtoConvertor.convert(mockUserDtoModel)).thenReturn(userModel);
	     	when(mockRefreshTokenService.getRefreshTokenByUser(userModel)).thenReturn(refreshTokenModel);
	     	
	     	BaseExceptionModel  exceptionModel = Assertions.assertThrows(UnSuccessfulException.class,()->{
	    		
	     		authService.login(loginRequestModel);
		});

	    assertEquals(exceptionModel.getErrorMessage(),UN_SUCCESSFUL_LOGIN.getExceptionMessage());
		assertEquals(exceptionModel.getErrorCode(), B_UN_SUCCESSFUL_EXCEPTION_ERROR_CODE + T_LOGIN + D_USER_ALREADY_LOGIN);
		 
	 }

	@Test
	 void Login_WhenRefreshTokenNotCreatedThenItMustThrowUnSuccessFulException() {

			authService = new AuthService(mockUserService,
					mockAccessTokenService,
					mockRefreshTokenService,
					mockConfirmationTokenService,
					mockUserDtoConvertor);
			
	     	when(mockUserService.getUserByUserName(loginRequestModel.getUserName())).thenReturn(mockUserDtoModel);
	     	when(mockUserDtoModel.getIsActive()).thenReturn(true);
	     	when(mockUserDtoConvertor.convert(mockUserDtoModel)).thenReturn(userModel);
	     	when(mockRefreshTokenService.getRefreshTokenByUser(mockUserModel)).thenReturn(null);
	     	when(mockRefreshTokenService.createRefreshToken(userModel)).thenReturn(null);
	     	
	     	BaseExceptionModel  exceptionModel = Assertions.assertThrows(UnSuccessfulException.class,()->{
	    		
	     		authService.login(loginRequestModel);
		});

	    assertEquals(exceptionModel.getErrorMessage(),UN_SUCCESSFUL_LOGIN.getExceptionMessage());
		assertEquals(exceptionModel.getErrorCode(), B_UN_SUCCESSFUL_EXCEPTION_ERROR_CODE + T_LOGIN + D_REFRESH_TOKEN_NOT_CREATED_OR_SAVED);
		 
	 }

	@Test
	 void Login_WhenRefreshTokenNotSavedThenItMustThrowUnSuccessFulException() {

		authService = new AuthService(mockUserService,
				mockAccessTokenService,
				mockRefreshTokenService,
				mockConfirmationTokenService,
				mockUserDtoConvertor);
		
     	when(mockUserService.getUserByUserName(loginRequestModel.getUserName())).thenReturn(mockUserDtoModel);
     	when(mockUserDtoModel.getIsActive()).thenReturn(true);
     	when(mockUserDtoConvertor.convert(mockUserDtoModel)).thenReturn(userModel);
     	when(mockRefreshTokenService.getRefreshTokenByUser(mockUserModel)).thenReturn(null);
     	when(mockRefreshTokenService.createRefreshToken(userModel)).thenReturn(refreshTokenModel);
     	when(mockRefreshTokenService.saveRefreshToken(refreshTokenModel)).thenReturn(null);
     	
     	BaseExceptionModel  exceptionModel = Assertions.assertThrows(UnSuccessfulException.class,()->{
    		
     		authService.login(loginRequestModel);
	});

    assertEquals(exceptionModel.getErrorMessage(),UN_SUCCESSFUL_LOGIN.getExceptionMessage());
	assertEquals(exceptionModel.getErrorCode(), B_UN_SUCCESSFUL_EXCEPTION_ERROR_CODE + T_LOGIN + D_REFRESH_TOKEN_NOT_CREATED_OR_SAVED);

		 
	 }

	@Test
	 void Login_WhenAccessTokenNotCreatedThenItMustThrowUnSuccessFulException() {

		authService = new AuthService(mockUserService,
				mockAccessTokenService,
				mockRefreshTokenService,
				mockConfirmationTokenService,
				mockUserDtoConvertor);
		
     	when(mockUserService.getUserByUserName(loginRequestModel.getUserName())).thenReturn(mockUserDtoModel);
     	when(mockUserDtoModel.getIsActive()).thenReturn(true);
     	when(mockUserDtoConvertor.convert(mockUserDtoModel)).thenReturn(userModel);
     	when(mockRefreshTokenService.getRefreshTokenByUser(userModel)).thenReturn(null);
     	when(mockRefreshTokenService.createRefreshToken(userModel)).thenReturn(refreshTokenModel);
     	when(mockRefreshTokenService.saveRefreshToken(refreshTokenModel)).thenReturn(refreshTokenModel);
     	when(mockAccessTokenService.createAccessToken(userModel)).thenReturn(null);
     	
     	BaseExceptionModel  exceptionModel = Assertions.assertThrows(UnSuccessfulException.class,()->{
    		
     		authService.login(loginRequestModel);
	});

    assertEquals(exceptionModel.getErrorMessage(),UN_SUCCESSFUL_LOGIN.getExceptionMessage());
	assertEquals(exceptionModel.getErrorCode(), B_UN_SUCCESSFUL_EXCEPTION_ERROR_CODE + T_LOGIN + D_ACCESS_TOKEN_NOT_CREATED_OR_SAVED);
		 
	 }

	@Test
	 void Login_WhenAccessTokenNotSavedThenItMustThrowUnSuccessFulException() {

		authService = new AuthService(mockUserService,
				mockAccessTokenService,
				mockRefreshTokenService,
				mockConfirmationTokenService,
				mockUserDtoConvertor);
		
     	when(mockUserService.getUserByUserName(loginRequestModel.getUserName())).thenReturn(mockUserDtoModel);
     	when(mockUserDtoModel.getIsActive()).thenReturn(true);
     	when(mockUserDtoConvertor.convert(mockUserDtoModel)).thenReturn(userModel);
     	when(mockRefreshTokenService.getRefreshTokenByUser(userModel)).thenReturn(null);
     	when(mockRefreshTokenService.createRefreshToken(userModel)).thenReturn(refreshTokenModel);
     	when(mockRefreshTokenService.saveRefreshToken(refreshTokenModel)).thenReturn(refreshTokenModel);
     	when(mockAccessTokenService.createAccessToken(userModel)).thenReturn(accesToken);
    	when(mockAccessTokenService.saveAccessToken(accesToken)).thenReturn(null);
     	
     	BaseExceptionModel  exceptionModel = Assertions.assertThrows(UnSuccessfulException.class,()->{
    		
     		authService.login(loginRequestModel);
	});

    assertEquals(exceptionModel.getErrorMessage(),UN_SUCCESSFUL_LOGIN.getExceptionMessage());
	assertEquals(exceptionModel.getErrorCode(), B_UN_SUCCESSFUL_EXCEPTION_ERROR_CODE + T_LOGIN + D_ACCESS_TOKEN_NOT_CREATED_OR_SAVED);
		 
	 }

	@Test
	 void Login_WhenLoginSuccesfullyThenItMustReturnLoginResponseThatContainsRefreshTokenAndAcessTokenAndUserInformation() {

		authService = new AuthService(mockUserService,
				mockAccessTokenService,
				mockRefreshTokenService,
				mockConfirmationTokenService,
				mockUserDtoConvertor);
		
     	when(mockUserService.getUserByUserName(loginRequestModel.getUserName())).thenReturn(mockUserDtoModel);
     	when(mockUserDtoModel.getIsActive()).thenReturn(true);
     	when(mockUserDtoConvertor.convert(mockUserDtoModel)).thenReturn(userModel);
     	when(mockRefreshTokenService.getRefreshTokenByUser(userModel)).thenReturn(null);
     	when(mockRefreshTokenService.createRefreshToken(userModel)).thenReturn(refreshTokenModel);
     	when(mockRefreshTokenService.saveRefreshToken(refreshTokenModel)).thenReturn(refreshTokenModel);
     	when(mockAccessTokenService.createAccessToken(userModel)).thenReturn(accesToken);
    	when(mockAccessTokenService.saveAccessToken(accesToken)).thenReturn(accesToken);

     	LoginResponse loginResponseReturned = authService.login(loginRequestModel);   
     	
	}

	
	
	
	 //refreshToken metod logic...
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
	
	@Test
	 void RefreshToken_WhenAccesTokenFoundAndAccessTokenVerifiedThenItMustThrowUnSuccessFulException() {

			authService = new AuthService(mockUserService,
					mockAccessTokenService,
					mockRefreshTokenService,
					mockConfirmationTokenService,
					mockUserDtoConvertor);
			
	     	when(mockAccessTokenService.getAccessTokenByAccessToken(accesToken)).thenReturn(accesToken);
	     	when(mockAccessTokenService.verifyAccessToken(accesToken)).thenReturn(true);
	     	
	     	BaseExceptionModel  exceptionModel = Assertions.assertThrows(UnSuccessfulException.class,()->{
	    		
	     		authService.refreshToken(refreshToken,accesToken);
		});

	    assertEquals(exceptionModel.getErrorMessage(),UN_SUCCESSFUL_RENEW_REFRESH_TOKEN.getExceptionMessage());
		assertEquals(exceptionModel.getErrorCode(), B_UN_SUCCESSFUL_EXCEPTION_ERROR_CODE + T_REFRESH_TOKEN + D_ACCESS_TOKEN_STILL_VALID);
		 
	 }

	@Test
	 void RefreshToken_WhenRefreshTokenNotFoundThenItMustThrowUnSuccessFulException() {
		

			authService = new AuthService(mockUserService,
					mockAccessTokenService,
					mockRefreshTokenService,
					mockConfirmationTokenService,
					mockUserDtoConvertor);
			
	     	when(mockAccessTokenService.getAccessTokenByAccessToken(accesToken)).thenReturn(accesToken);
	     	when(mockAccessTokenService.verifyAccessToken(accesToken)).thenReturn(false);
	     	when(mockRefreshTokenService.getRefreshTokenByRefreshToken(refreshToken)).thenReturn(null);
	     	
	     	BaseExceptionModel  exceptionModel = Assertions.assertThrows(UnSuccessfulException.class,()->{
	    		
	     		authService.refreshToken(refreshToken,accesToken);
		});

	    assertEquals(exceptionModel.getErrorMessage(),UN_SUCCESSFUL_RENEW_REFRESH_TOKEN.getExceptionMessage());
		assertEquals(exceptionModel.getErrorCode(), B_UN_SUCCESSFUL_EXCEPTION_ERROR_CODE + T_REFRESH_TOKEN + D_REFRESH_TOKEN_NOT_FOUND);
		 
	 }
	
	@Test
	 void RefreshToken_WhenRefreshTokenNotVerifiedThenItMustThrowUnSuccessFulException() {
		

			authService = new AuthService(mockUserService,
					mockAccessTokenService,
					mockRefreshTokenService,
					mockConfirmationTokenService,
					mockUserDtoConvertor);
			
	     	when(mockAccessTokenService.getAccessTokenByAccessToken(accesToken)).thenReturn(accesToken);
	     	when(mockAccessTokenService.verifyAccessToken(accesToken)).thenReturn(false);
	     	when(mockRefreshTokenService.getRefreshTokenByRefreshToken(refreshToken)).thenReturn(refreshTokenModel);
	     	when(mockRefreshTokenService.verifyRefreshToken(refreshToken)).thenReturn(false);
	     	
	     	BaseExceptionModel  exceptionModel = Assertions.assertThrows(UnSuccessfulException.class,()->{
	    		
	     		authService.refreshToken(refreshToken,accesToken);
		});

	    assertEquals(exceptionModel.getErrorMessage(),UN_SUCCESSFUL_RENEW_REFRESH_TOKEN.getExceptionMessage());
		assertEquals(exceptionModel.getErrorCode(), B_UN_SUCCESSFUL_EXCEPTION_ERROR_CODE + T_REFRESH_TOKEN + D_REFRESH_TOKEN_NOT_VALID);
		 
	 }
	
	@Test
	 void RefreshToken_WhenRefreshTokenSuccesfullyThenItMustReturnRefreshTokenResponseThatContainsRefreshTokenAndAcessTokenAndUserInformation() {

		authService = new AuthService(mockUserService,
				mockAccessTokenService,
				mockRefreshTokenService,
				mockConfirmationTokenService,
				mockUserDtoConvertor);
		
     	when(mockAccessTokenService.getAccessTokenByAccessToken(accesToken)).thenReturn(accesToken);
     	when(mockAccessTokenService.verifyAccessToken(accesToken)).thenReturn(false);
     	when(mockRefreshTokenService.getRefreshTokenByRefreshToken(refreshToken)).thenReturn(refreshTokenModel);
     	when(mockRefreshTokenService.verifyRefreshToken(refreshToken)).thenReturn(true);
     	
     	RefreshTokenResponse refreshTokenResponseReturned = authService.refreshToken(refreshToken,accesToken);
     	
 }
	
	
	//logout metod logic...
	/* Logic Onion
	 * 
	 * refresh token ok ??
	 * refresh token is exist - delete??
	 * 
	 */
	

}

