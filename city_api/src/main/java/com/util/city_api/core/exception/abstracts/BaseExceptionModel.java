package com.util.city_api.core.exception.abstracts;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.util.city_api.core.constant.CoreEnumExceptionMessages;

@ResponseStatus
public class BaseExceptionModel extends RuntimeException implements Serializable{

	   	private static final long serialVersionUID = 1L;
		
	   	private LocalDateTime timeStamp;
	    private String errorTopicCode;
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
	        errorTopicCode = coreEnumExceptionMessages.getExceptionCode();
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
	        
	        return baseErrorCode + 
	        	   errorTopicCode + 
	        	   errorDetailCode;
	    }

	    public HttpStatus getBaseStatusCode() {
	        return baseStatusCode;
	    }
	
}
