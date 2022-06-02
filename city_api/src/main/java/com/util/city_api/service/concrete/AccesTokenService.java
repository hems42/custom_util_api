package com.util.city_api.service.concrete;

import org.springframework.stereotype.Service;

import com.util.city_api.entity.primary.User;
import com.util.city_api.product_core.security.JwtUtil;
import com.util.city_api.service._abstract.IAccesTokenService;

@Service
public class AccesTokenService implements IAccesTokenService{

	private final JwtUtil jwtUtil;
	
	public AccesTokenService(JwtUtil jwtUtil) {
		
		this.jwtUtil = jwtUtil;
	}
	
	
	@Override
	public String createAccessToken(User user) {
		// TODO Auto-generated method stub
		return "gkgjkg";
	}

	@Override
	public String saveAccessToken(String accessToken) {
		// TODO Auto-generated method stub
		return "hjkhkjhkj";
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
