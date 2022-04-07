package com.util.city_api.core.exception.abstracts;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.util.city_api.core.constant.CoreEnumExceptionMessages;

@ResponseStatus
public class BaseExceptionModel extends RuntimeException {

	    private LocalDateTime timeStamp;
	    private String errorCode;
	    private String errorDetailCode;
	    private String errorMessage;
	    private String errorDescription;
	    private String baseErrorCode;
	    private HttpStatus baseStatusCode;
	    private CoreEnumExceptionMessages coreEnumExceptionMessages;

	    public BaseExceptionModel(CoreEnumExceptionMessages coreEnumExceptionMessages,
	                              String baseErrorCode,
	                              String errorDetailCode,
	                              String errorDescription,
	                              HttpStatus baseStatusCode) {
	        super(errorDescription); 
	        this.coreEnumExceptionMessages = coreEnumExceptionMessages;
	        errorCode = coreEnumExceptionMessages.getExceptionCode();
	        errorMessage = coreEnumExceptionMessages.getExceptionMessage();
	        this.errorDescription = errorDescription;
	        this.baseErrorCode = baseErrorCode;
	        this.errorDetailCode = errorDetailCode;
	        this.baseStatusCode = baseStatusCode;


	    }
 
	    public LocalDateTime getTimeStamp() {
	        return LocalDateTime.now();
	    }

	    public String getErrorCode() {
	        return convertToSuperErrorCode();
	    }

	    public String getErrorMessage() {
	        return errorMessage;
	    }

	    public String getErrorDescription() {
	        return errorDescription;
	    }

	    private String convertToSuperErrorCode() {
	        String foundErrorCode = coreEnumExceptionMessages.getExceptionCode();
	        return baseErrorCode + foundErrorCode + errorDetailCode;
	    }

	    public HttpStatus getBaseStatusCode() {
	        return baseStatusCode;
	    }
	
}
