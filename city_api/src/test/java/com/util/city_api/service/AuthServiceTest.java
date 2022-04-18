package com.util.city_api.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.util.city_api.core.exception.abstracts.BaseExceptionModel;
import com.util.city_api.core.exception.exceptionModels.UnSuccessfulException;
import com.util.city_api.product_core.request.createRequest.UserCreateRequest;
import com.util.city_api.service.concrete.AuthService;
import com.util.city_api.service.mockWorkbench.AuthServiceTestWorkBench;

import static org.junit.jupiter.api.Assertions.assertEquals;


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
	void WhenUserAlReadyCreatedByEmailThenItMustThrowUnSuccessFulException() {

		authService = new AuthService(mockUserService,
				mockAccessTokenService,
				mockRefreshTokenService,
				mockConfirmationTokenService,
				mockUserDtoConvertor);
		
     	Mockito.when(mockUserService.isExistUserByEmail(signupRequestModel.getEmail())).thenReturn(true);
		
     	BaseExceptionModel  exceptionModel = Assertions.assertThrows(UnSuccessfulException.class,()->{
		
     		authService.signup(signupRequestModel);
	});

    assertEquals(exceptionModel.getErrorMessage(),UN_SUCCESSFUL_SIGNUP.getExceptionMessage());
	assertEquals(exceptionModel.getErrorCode(), UN_SUCCESSFUL_EXCEPTION_ERROR_CODE + SIGNUP + EMAIL_ALREADY_USED);
	
	} 

	@Test
	void WhenUserAlReadyCreatedByUsernameThenItMustThrowUnSuccessFulException() {

		authService = new AuthService(mockUserService,
				mockAccessTokenService,
				mockRefreshTokenService,
				mockConfirmationTokenService,
				mockUserDtoConvertor);
		
     	Mockito.when(mockUserService.isExistUserByEmail(signupRequestModel.getEmail())).thenReturn(false);
     	Mockito.when(mockUserService.isExistUserByUserName(signupRequestModel.getUsername())).thenReturn(true);
		
     	BaseExceptionModel  exceptionModel = Assertions.assertThrows(UnSuccessfulException.class,()->{
		
     		authService.signup(signupRequestModel);
	});

    assertEquals(exceptionModel.getErrorMessage(),UN_SUCCESSFUL_SIGNUP.getExceptionMessage());
	assertEquals(exceptionModel.getErrorCode(), UN_SUCCESSFUL_EXCEPTION_ERROR_CODE + SIGNUP + USERNAME_ALREADY_USED);
	
	}
	
	@Test
	void WhenUserNotCreatedSuccessfullyThenItMustThrowUnSuccessFulException() {
		
		authService = new AuthService(mockUserService,
				mockAccessTokenService,
				mockRefreshTokenService,
				mockConfirmationTokenService,
				mockUserDtoConvertor);
		
     	Mockito.when(mockUserService.isExistUserByEmail(signupRequestModel.getEmail())).thenReturn(false);
     	Mockito.when(mockUserService.isExistUserByUserName(signupRequestModel.getUsername())).thenReturn(false);
     	Mockito.when(mockUserService.createUser(userCreateRequestModel)).thenReturn(userDtoModel);
		
     	BaseExceptionModel  exceptionModel = Assertions.assertThrows(UnSuccessfulException.class,()->{
		
     		authService.signup(signupRequestModel);
	});

    assertEquals(exceptionModel.getErrorMessage(),UN_SUCCESSFUL_SIGNUP.getExceptionMessage());
	assertEquals(exceptionModel.getErrorCode(), UN_SUCCESSFUL_EXCEPTION_ERROR_CODE + SIGNUP + USER_NOT_CREATED);
	}
	
	@Test
	void WhenRefreshTokenNotCreatedSuccessfullyThenItMustThrowUnSuccessFulException() {
		
		authService = new AuthService(mockUserService,
				mockAccessTokenService,
				mockRefreshTokenService,
				mockConfirmationTokenService,
				mockUserDtoConvertor);
		
     	Mockito.when(mockUserService.isExistUserByEmail(signupRequestModel.getEmail())).thenReturn(false);
     	Mockito.when(mockUserService.isExistUserByUserName(signupRequestModel.getUsername())).thenReturn(false);
     	Mockito.when(mockUserService.createUser(new UserCreateRequest(signupRequestModel.getEmail(),
     			signupRequestModel.getUsername(),
     			signupRequestModel.getPassword()))).thenReturn(userDtoModel);
		Mockito.when(mockRefreshTokenService.createRefreshToken(userModel)).thenReturn(null);
		
     	BaseExceptionModel  exceptionModel = Assertions.assertThrows(UnSuccessfulException.class,()->{
		
     		authService.signup(signupRequestModel);
	});

    assertEquals(exceptionModel.getErrorMessage(),UN_SUCCESSFUL_SIGNUP.getExceptionMessage());
	assertEquals(exceptionModel.getErrorCode(), UN_SUCCESSFUL_EXCEPTION_ERROR_CODE + SIGNUP + REFRESH_TOKEN_NOT_CREATED_OR_SAVED);
	}
	
	@Test
	void WhenRefreshTokenNotSavedSuccessfullyThenItMustThrowUnSuccessFulException() {
		
		authService = new AuthService(mockUserService,
				mockAccessTokenService,
				mockRefreshTokenService,
				mockConfirmationTokenService,
				mockUserDtoConvertor);
		
     	Mockito.when(mockUserService.isExistUserByEmail(signupRequestModel.getEmail())).thenReturn(false);
     	Mockito.when(mockUserService.isExistUserByUserName(signupRequestModel.getUsername())).thenReturn(false);
     	Mockito.when(mockUserService.createUser(new UserCreateRequest(signupRequestModel.getEmail(),signupRequestModel.getUsername(),signupRequestModel.getPassword()))).thenReturn(userDtoModel);
		Mockito.when(mockUserDtoConvertor.convert(userDtoModel)).thenReturn(userModel);
     	Mockito.when(mockRefreshTokenService.createRefreshToken(userModel)).thenReturn(refreshTokenModel);
		Mockito.when(mockRefreshTokenService.saveRefreshToken(refreshTokenModel)).thenReturn(null);
		
     	BaseExceptionModel  exceptionModel = Assertions.assertThrows(UnSuccessfulException.class,()->{
		
     		authService.signup(signupRequestModel);
	});

    assertEquals(exceptionModel.getErrorMessage(),UN_SUCCESSFUL_SIGNUP.getExceptionMessage());
	assertEquals(exceptionModel.getErrorCode(), UN_SUCCESSFUL_EXCEPTION_ERROR_CODE + SIGNUP + REFRESH_TOKEN_NOT_CREATED_OR_SAVED);
	}
	
	@Test
	void WhenAccessTokenNotCreatedSuccessfullyThenItMustThrowUnSuccessFulException() {
		
		authService = new AuthService(mockUserService,
				mockAccessTokenService,
				mockRefreshTokenService,
				mockConfirmationTokenService,
				mockUserDtoConvertor);
		
     	Mockito.when(mockUserService.isExistUserByEmail(signupRequestModel.getEmail())).thenReturn(false);
     	Mockito.when(mockUserService.isExistUserByUserName(signupRequestModel.getUsername())).thenReturn(false);
     	Mockito.when(mockUserService.createUser(new UserCreateRequest(signupRequestModel.getEmail(),signupRequestModel.getUsername(),signupRequestModel.getPassword()))).thenReturn(userDtoModel);
		Mockito.when(mockUserDtoConvertor.convert(userDtoModel)).thenReturn(userModel);
     	Mockito.when(mockRefreshTokenService.createRefreshToken(userModel)).thenReturn(refreshTokenModel);
		Mockito.when(mockRefreshTokenService.saveRefreshToken(refreshTokenModel)).thenReturn(refreshTokenModel);
		Mockito.when(mockAccessTokenService.createAccessToken(userModel)).thenReturn(accesToken);
		
     	BaseExceptionModel  exceptionModel = Assertions.assertThrows(UnSuccessfulException.class,()->{
		
     		authService.signup(signupRequestModel);
	});

    assertEquals(exceptionModel.getErrorMessage(),UN_SUCCESSFUL_SIGNUP.getExceptionMessage());
	assertEquals(exceptionModel.getErrorCode(), UN_SUCCESSFUL_EXCEPTION_ERROR_CODE + SIGNUP + ACCESS_TOKEN_NOT_CREATED_OR_SAVED);
	}
	
	@Test
	void WhenAccessTokenNotSavedSuccessfullyThenItMustThrowUnSuccessFulException() {
		
		authService = new AuthService(mockUserService,
				mockAccessTokenService,
				mockRefreshTokenService,
				mockConfirmationTokenService,
				mockUserDtoConvertor);
		
     	Mockito.when(mockUserService.isExistUserByEmail(signupRequestModel.getEmail())).thenReturn(false);
     	Mockito.when(mockUserService.isExistUserByUserName(signupRequestModel.getUsername())).thenReturn(false);
     	Mockito.when(mockUserService.createUser(new UserCreateRequest(signupRequestModel.getEmail(),signupRequestModel.getUsername(),signupRequestModel.getPassword()))).thenReturn(userDtoModel);
		Mockito.when(mockUserDtoConvertor.convert(userDtoModel)).thenReturn(userModel);
     	Mockito.when(mockRefreshTokenService.createRefreshToken(userModel)).thenReturn(refreshTokenModel);
		Mockito.when(mockRefreshTokenService.saveRefreshToken(refreshTokenModel)).thenReturn(refreshTokenModel);
		Mockito.when(mockAccessTokenService.createAccessToken(userModel)).thenReturn(accesToken);
		Mockito.when(mockAccessTokenService.saveAccessToken(accesToken)).thenReturn(null);

		
     	BaseExceptionModel  exceptionModel = Assertions.assertThrows(UnSuccessfulException.class,()->{
		
     		authService.signup(signupRequestModel);
	});

    assertEquals(exceptionModel.getErrorMessage(),UN_SUCCESSFUL_SIGNUP.getExceptionMessage());
	assertEquals(exceptionModel.getErrorCode(), UN_SUCCESSFUL_EXCEPTION_ERROR_CODE + SIGNUP + ACCESS_TOKEN_NOT_CREATED_OR_SAVED);
	}

	void WhenSignupSuccesfullyThenItMustReturnSignupResponseThatContainsSameInformationWithSignupRequest() {
		
	}

}
