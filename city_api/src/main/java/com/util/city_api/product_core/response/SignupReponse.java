package com.util.city_api.product_core.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignupReponse {

	String username;
	String email;
	String accessToken;
	String refreshToken;
	String expireTimeAccessToken;
	String expireTimeRefreshToken;
}
