package com.util.city_api.service._abstract;

import com.util.city_api.product_core.request.createRequest.LoginRequest;
import com.util.city_api.product_core.request.createRequest.ResetPasswordRequest;
import com.util.city_api.product_core.request.createRequest.SignupRequest;
import com.util.city_api.product_core.response.LogoutResponse;
import com.util.city_api.product_core.response.LoginResponse;
import com.util.city_api.product_core.response.RefreshTokenResponse;
import com.util.city_api.product_core.response.RegistrationResponse;
import com.util.city_api.product_core.response.ResetPasswordResponse;
import com.util.city_api.product_core.response.SignupReponse;

public interface IAuthService {

	SignupReponse signup(SignupRequest signupRequest);
	
    RegistrationResponse register(String confirmationToken);

    LoginResponse login(LoginRequest loginRequest);

    RefreshTokenResponse refreshToken(String refreshToken, String accessToken);

    LogoutResponse logout(String refreshToken);

    ResetPasswordResponse resetPassword(ResetPasswordRequest resetPasswordRequest);

}
