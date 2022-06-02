package com.util.city_api.service.concrete;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.util.city_api.dao.RefreshTokenDao;
import com.util.city_api.entity.primary.User;
import com.util.city_api.entity.security.RefreshToken;
import com.util.city_api.product_core.constants.ProductApplicationConstants;
import com.util.city_api.service._abstract.IRefreshTokenService;

import ch.qos.logback.core.CoreConstants;

@Service
public class RefreshTokenService implements IRefreshTokenService{

	private final RefreshTokenDao refreshTokenRepository;
	
	public RefreshTokenService(RefreshTokenDao refreshTokenRepository) {
		
		this.refreshTokenRepository = refreshTokenRepository;
	}
	
	@Override
	public RefreshToken createRefreshToken(User user) {	  
		return new RefreshToken(
				null,
				user,
				UUID.randomUUID().toString(),
				LocalDateTime.now().plusNanos(ProductApplicationConstants.REFRESH_TOKEN_EXPERIMENT_TIME),
				LocalDateTime.now()
				);
	} 

	@Override
	public RefreshToken saveRefreshToken(RefreshToken refreshToken) {
		
		  return refreshTokenRepository.save(refreshToken);
		  
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
