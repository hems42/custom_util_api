package com.util.city_api.service.concrete;

import org.springframework.stereotype.Service;

import com.util.city_api.dao.RefreshTokenDao;
import com.util.city_api.entity.primary.User;
import com.util.city_api.entity.security.RefreshToken;
import com.util.city_api.service._abstract.IRefreshTokenService;

@Service
public class RefreshTokenService implements IRefreshTokenService{

	private final RefreshTokenDao refreshTokenRepository;
	
	public RefreshTokenService(RefreshTokenDao refreshTokenRepository) {
		
		this.refreshTokenRepository = refreshTokenRepository;
	}
	
	@Override
	public RefreshToken createRefreshToken(User user) {
		// TODO Auto-generated method stub
		return null;
	} 

	@Override
	public RefreshToken saveRefreshToken(RefreshToken refreshToken) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RefreshToken getRefreshTokenByUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RefreshToken getRefreshTokenByRefreshToken(String refreshToken) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean verifyRefreshToken(String refreshToken) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteRefreshTokenByRefreshToken(RefreshToken refreshToken) {		
		refreshTokenRepository.delete(refreshToken);		
	}

}
