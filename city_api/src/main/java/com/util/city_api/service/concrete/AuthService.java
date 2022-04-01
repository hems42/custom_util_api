package com.util.city_api.service.concrete;

import com.util.city_api.product_core.request.createRequest.SignupRequest;
import com.util.city_api.product_core.response.SignupReponse;
import com.util.city_api.service._abstract.IAuthService;

public class AuthService implements IAuthService{

	@Override
	public SignupReponse signup(SignupRequest signupRequest) {
		
		
		/* LOGIC
		 * 
		 *  request ok
		 * user created allready
		 * refresh token create
		 * accesstoken create
		 * confirm token create
		 * emial send
		 * 
		 * 
		 */
		
		
		
		// NOTE : user device platfrom checking and modifying user creating...
		return null;
	}

}
