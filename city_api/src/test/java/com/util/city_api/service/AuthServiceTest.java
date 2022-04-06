package com.util.city_api.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.util.city_api.core.constant.CoreConstantExceptionErrorCode;
import com.util.city_api.core.constant.CoreEnumExceptionMessages;
import com.util.city_api.core.exception.exceptionModels.UnAuthorizeException;
import com.util.city_api.service._abstract.IAccesTokenService;
import com.util.city_api.service._abstract.IAuthService;
import com.util.city_api.service._abstract.IConfirmationTokenService;
import com.util.city_api.service._abstract.IRefreshTokenService;
import com.util.city_api.service._abstract.IUserService;
import com.util.city_api.service.concrete.AuthService;

public class AuthServiceTest {
	
	IUserService userService;
    IAccesTokenService accessTokenService;
    IRefreshTokenService refreshTokenService;
    IConfirmationTokenService confirmationTokenService;	
	IAuthService authService;
	

	@BeforeEach
	void setup() {
		
		authService = new AuthService(null,null,null,null);
	}
	
	

	
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
	void WhenUserAllReadyCreatedByUsernameThenItMustThrow__Exception() {
	//throw 	new UnAuthorizeException(CoreEnumExceptionMessages.UNAUTHORIZED_REQUEST,"gidecek hata mesajı");
		
	//System.out.println("gelen hata kodu :"+CoreConstantExceptionErrorCode.ALREADY_EXIST_EXCEPTION_ERROR_CODE); 
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
