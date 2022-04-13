package com.util.city_api.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.util.city_api.baseMockModel.BaseMockServiceAndServiceModel;
import com.util.city_api.core.exception.abstracts.BaseExceptionModel;
import com.util.city_api.core.exception.exceptionModels.UnSuccessfulException;
import com.util.city_api.entity._core.User;
import com.util.city_api.entity.security.RefreshToken;
import com.util.city_api.product_core.dto._coreDto.UserDto;
import com.util.city_api.product_core.dtoConvertor.UserDtoConvertor;
import com.util.city_api.product_core.request.createRequest.UserCreateRequest;
import com.util.city_api.service._abstract.IAccesTokenService;
import com.util.city_api.service._abstract.IAuthService;
import com.util.city_api.service._abstract.IConfirmationTokenService;
import com.util.city_api.service._abstract.IRefreshTokenService;
import com.util.city_api.service._abstract.IUserService;
import com.util.city_api.service.concrete.AuthService;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import static com.util.city_api.core.constant.CoreConstantExceptionErrorCode.*;
import static com.util.city_api.core.constant.CoreEnumExceptionMessages.*;

public class AuthServiceTest extends BaseMockServiceAndServiceModel{
	
	// service
	IAuthService authService;
	IUserService userService = getUserService();
	IUserService mockUserService = getMockUserService();
    IAccesTokenService accessTokenService = getAccesTokenService();
    IAccesTokenService mockAccessTokenService = getMockAccesTokenService();
    IRefreshTokenService refreshTokenService = getRefreshTokenService();
    IRefreshTokenService mockRefreshTokenService = getMockRefreshTokenService();
    IConfirmationTokenService confirmationTokenService = getConfirmationtokenService();
    IConfirmationTokenService mockConfirmationTokenService = getMockConfirmationTokenService();
    
    // convertor
    UserDtoConvertor userDtoConvertor = getUserDtoConvertor();
    UserDtoConvertor mockUserDtoConvertor = getMockUserDtoConvertor();
	
    // model
    User userModel = getUserModel();
	User mockUsermodel = getMockUserModel();
	UserDto userDtoModel = getUserDtoModel();
	UserDto mockUserDtoModel = getMockUserDtoModel();
	RefreshToken refreshTokenModel = getRefreshToken();
	UserCreateRequest userCreateRequestModel = getUserCreateRequest();
	
	
	// util
	LocalDateTime time = getDateTime();
    
		

	
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
		
     	Mockito.when(mockUserService.isExistUserByEmail(getSignupRequestModel().getEmail())).thenReturn(true);
		
     	BaseExceptionModel  exceptionModel = Assertions.assertThrows(UnSuccessfulException.class,()->{
		
     		authService.signup(getSignupRequestModel());
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
		
     	Mockito.when(mockUserService.isExistUserByEmail(getSignupRequestModel().getEmail())).thenReturn(false);
     	Mockito.when(mockUserService.isExistUserByUserName(getSignupRequestModel().getUsername())).thenReturn(true);
		
     	BaseExceptionModel  exceptionModel = Assertions.assertThrows(UnSuccessfulException.class,()->{
		
     		authService.signup(getSignupRequestModel());
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
		
     	Mockito.when(mockUserService.isExistUserByEmail(getSignupRequestModel().getEmail())).thenReturn(false);
     	Mockito.when(mockUserService.isExistUserByUserName(getSignupRequestModel().getUsername())).thenReturn(false);
     	Mockito.when(mockUserService.createUser(getUserCreateRequest())).thenReturn(userDtoModel);
		
     	BaseExceptionModel  exceptionModel = Assertions.assertThrows(UnSuccessfulException.class,()->{
		
     		authService.signup(getSignupRequestModel());
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
		
     	Mockito.when(mockUserService.isExistUserByEmail(getSignupRequestModel().getEmail())).thenReturn(false);
     	Mockito.when(mockUserService.isExistUserByUserName(getSignupRequestModel().getUsername())).thenReturn(false);
     	Mockito.when(mockUserService.createUser(userCreateRequestModel)).thenReturn(userDtoModel);
		Mockito.when(mockRefreshTokenService.createRefreshToken(userModel)).thenReturn(null);
		
     	BaseExceptionModel  exceptionModel = Assertions.assertThrows(UnSuccessfulException.class,()->{
		
     		authService.signup(getSignupRequestModel());
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
		
     	Mockito.when(mockUserService.isExistUserByEmail(getSignupRequestModel().getEmail())).thenReturn(false);
     	Mockito.when(mockUserService.isExistUserByUserName(getSignupRequestModel().getUsername())).thenReturn(false);
     	Mockito.when(mockUserService.createUser(getUserCreateRequest())).thenReturn(userDtoModel);
		Mockito.when(mockRefreshTokenService.createRefreshToken(getMockUserModel())).thenReturn(refreshTokenModel);
		Mockito.when(mockRefreshTokenService.saveRefreshToken(refreshTokenModel)).thenReturn(null);
		
     	BaseExceptionModel  exceptionModel = Assertions.assertThrows(UnSuccessfulException.class,()->{
		
     		authService.signup(getSignupRequestModel());
	});

    assertEquals(exceptionModel.getErrorMessage(),UN_SUCCESSFUL_SIGNUP.getExceptionMessage());
	assertEquals(exceptionModel.getErrorCode(), UN_SUCCESSFUL_EXCEPTION_ERROR_CODE + SIGNUP + REFRESH_TOKEN_NOT_CREATED_OR_SAVED);
	}
	
	
}
