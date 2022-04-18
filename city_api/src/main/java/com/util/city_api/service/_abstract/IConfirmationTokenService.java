package com.util.city_api.service._abstract;

import com.util.city_api.entity._core.User;
import com.util.city_api.entity.security.ConfirmationToken;

public interface IConfirmationTokenService {

	
	ConfirmationToken createConfirmationToken(User user);
	
	ConfirmationToken saveConfirmationToken(ConfirmationToken confirmationToken);
}
