package com.util.city_api.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.print.Printable;

import static com.util.city_api.core.constant.CoreConstantExceptionErrorCode.*;
import static com.util.city_api.core.constant.CoreEnumExceptionMessages.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.util.city_api.baseMock.BaseMockServiceAndServiceAndRequestModel;
import com.util.city_api.core.exception.abstracts.BaseExceptionModel;
import com.util.city_api.core.exception.exceptionModels.UnSuccessfulException;
import com.util.city_api.service._abstract.IAccesTokenService;
import com.util.city_api.service._abstract.IAuthService;
import com.util.city_api.service._abstract.IConfirmationTokenService;
import com.util.city_api.service._abstract.IRefreshTokenService;
import com.util.city_api.service._abstract.IUserService;
import com.util.city_api.service.concrete.AuthService;

public class AuthServiceTest extends BaseMockServiceAndServiceAndRequestModel{
	
	IUserService userService;
    IAccesTokenService accessTokenService;
    IRefreshTokenService refreshTokenService;
    IConfirmationTokenService confirmationTokenService;	
	IAuthService authService;
		

	
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
	void WhenUserAlReadyCreatedByUsernameThenItMustThrowUnSuccessFulException() {

		authService = new AuthService(getMockUserService(),getMockAccesTokenService(),getMockRefreshTokenService(),getMockConfirmationTokenService());
		
     	Mockito.when(getMockUserService().isExistUserByEmail(getSignupRequestModel().getEmail())).thenReturn(true);
		
     	BaseExceptionModel  exceptionModel = Assertions.assertThrows(UnSuccessfulException.class,()->{
     		authService.signup(getSignupRequestModel());
	});

    assertEquals(exceptionModel.getErrorMessage(),UN_SUCCESSFUL_SIGNUP.getExceptionMessage());
	assertEquals(exceptionModel.getErrorCode(), UN_SUCCESSFUL_EXCEPTION_ERROR_CODE + SIGNUP + EMAIL_ALREADY_USED);
	
	}


	@Test
	void t1() {}
	
	@Test
	void t2() {}
	
	@Test
	void t3() {}
	
	@Test
	void t4() {}
	
	@Test
	void t5() {}
	
	@Test
	void t6() {}
	
	@Test
	void t7() {}
	
	@Test
	void t8() {}
	
	@Test
	void t9() {}
	
	@Test
	void t10() {}
	
	@Test
	void t11() {}
	
	@Test
	void t12() {}
	
	@Test
	void t13() {}
	
	@Test
	void t14() {}
	
	@Test
	void t15() {}
	
	@Test
	void t16() {}
}
