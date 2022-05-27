package com.util.city_api.service._abstract;

import com.util.city_api.entity.primary.User;

public interface IAccesTokenService {

	String createAccessToken(User user);
	
	String saveAccessToken(String accessToken);
	
	String getAccessTokenByAccessToken(String accessToken);
	
	Boolean verifyAccessToken(String accessToken);
}
