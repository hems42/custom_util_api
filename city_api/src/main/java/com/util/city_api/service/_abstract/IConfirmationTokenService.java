package com.util.city_api.service._abstract;

import com.util.city_api.entity.primary.User;
import com.util.city_api.entity.security.ConfirmationToken;

public interface IConfirmationTokenService {

	// create
	ConfirmationToken createConfirmationToken(User user);
		
	ConfirmationToken saveConfirmationToken(ConfirmationToken confirmationToken);
	
	//----------
	
	
	// select
	ConfirmationToken getConfirmationTokenByConfirmationToken(String confirmationToken);
		
	//----------
	
		
	// update	
	Boolean updateRegisteredConfirmationToken(ConfirmationToken confirmationToken);	
		
	//----------
		
		
	// delete
		
	//----------	
		
		
		
		
		
	// isCheck
	Boolean isExistConfirmationToken(String confirmationToken);
	
	Boolean isExpiredConfirmationToken(String confirmationToken);

	Boolean isAlreadyUsed(String confirmationToken);
	
	//----------
	
	
}
