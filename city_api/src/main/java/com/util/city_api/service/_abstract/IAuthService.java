package com.util.city_api.service._abstract;

import com.util.city_api.product_core.request.createRequest.SignupRequest;
import com.util.city_api.product_core.response.SignupReponse;

public interface IAuthService {

	SignupReponse signup(SignupRequest signupRequest);
}
