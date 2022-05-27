package com.util.city_api.service.concrete;

import org.springframework.stereotype.Service;

import com.util.city_api.entity.primary.User;
import com.util.city_api.entity.security.ConfirmationToken;
import com.util.city_api.service._abstract.IConfirmationTokenService;

@Service
public class ConfirmationTokenService implements IConfirmationTokenService{

	@Override
	public ConfirmationToken createConfirmationToken(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ConfirmationToken saveConfirmationToken(ConfirmationToken confirmationToken) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean isExistConfirmationToken(String confirmationToken) {
		// TODO Auto-generated method stub
		return null;
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
