package com.util.city_api.service.concrete;

import org.springframework.stereotype.Service;

import com.util.city_api.entity._core.User;
import com.util.city_api.entity.security.RefreshToken;
import com.util.city_api.service._abstract.IRefreshTokenService;

@Service
public class RefreshTokenService implements IRefreshTokenService{

	@Override
	public RefreshToken createRefreshToken(User _user) {
		// TODO Auto-generated method stub
		return null;
	} 

	@Override
	public RefreshToken saveRefreshToken(RefreshToken refreshToken) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RefreshToken getRefreshTokenByUser(User _user) {
		// TODO Auto-generated method stub
		return null;
	}

}
