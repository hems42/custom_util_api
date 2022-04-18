package com.util.city_api.service._abstract;

import com.util.city_api.entity._core.User;

public interface IAccesTokenService {

	String createAccessToken(User user);
	
	String saveAccessToken(String accessToken);
}
