package com.util.city_api.service.concrete;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.util.city_api.dao.ConfirmationTokenDao;
import com.util.city_api.entity.primary.User;
import com.util.city_api.entity.security.ConfirmationToken;
import com.util.city_api.product_core.constants.ProductApplicationConstants;
import com.util.city_api.service._abstract.IConfirmationTokenService;

@Service
public class ConfirmationTokenService implements IConfirmationTokenService{

	private final ConfirmationTokenDao confirmationTokenRepository;
	
	public  ConfirmationTokenService(ConfirmationTokenDao confirmationTokenRepository) {
		
		this.confirmationTokenRepository = confirmationTokenRepository;
	}
	
	@Override
	public ConfirmationToken createConfirmationToken(User user) {
		
		return new ConfirmationToken(
                null,
                user,
                UUID.randomUUID().toString(),
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(ProductApplicationConstants.CONFIRMATION_TOKEN_EXPERIMENT_TIME),
                null
        );
	}

	@Override
	public ConfirmationToken saveConfirmationToken(ConfirmationToken confirmationToken) {
		
		return confirmationTokenRepository.save(confirmationToken);
	}

	@Override
	public Boolean isExistConfirmationToken(String confirmationToken) {
		
		return true;
	}


	@Override
	public Boolean isExpiredConfirmationToken(String confirmationToken) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean isAlreadyUsed(String confirmationToken) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ConfirmationToken getConfirmationTokenByConfirmationToken(String confirmationToken) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean updateRegisteredConfirmationToken(ConfirmationToken confirmationToken) {
		// TODO Auto-generated method stub
		return null;
	}



}
