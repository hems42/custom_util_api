package com.util.city_api.service._abstract;

import com.util.city_api.product_core.request.createRequest.LoginRequest;
import com.util.city_api.product_core.request.createRequest.SignupRequest;
import com.util.city_api.product_core.response.LogOutResponse;
import com.util.city_api.product_core.response.LoginResponse;
import com.util.city_api.product_core.response.RefreshTokenResponse;
import com.util.city_api.product_core.response.RegistrationResponse;
import com.util.city_api.product_core.response.SignupReponse;

public interface IAuthService {

	SignupReponse signup(SignupRequest signupRequest);
	
    RegistrationResponse register(String confirmationToken);

    LoginResponse login(LoginRequest loginRequest);

    RefreshTokenResponse refreshToken(String refreshToken, String accessToken);

    LogOutResponse logout(String refreshToken);

    //void forgetPassword(String user);

    //void reSendEmail(String userId);
}
