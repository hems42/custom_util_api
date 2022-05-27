package com.util.city_api.service.concrete;

import org.springframework.stereotype.Service;

import com.util.city_api.entity.primary.User;
import com.util.city_api.service._abstract.IAccesTokenService;

@Service
public class AccesTokenService implements IAccesTokenService{

	@Override
	public String createAccessToken(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String saveAccessToken(String accessToken) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAccessTokenByAccessToken(String accessToken) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean verifyAccessToken(String accessToken) {
		// TODO Auto-generated method stub
		return null;
	}

}
