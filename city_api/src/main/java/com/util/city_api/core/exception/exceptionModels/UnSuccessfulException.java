package com.util.city_api.core.exception.exceptionModels;

import com.util.city_api.core.constant.CoreEnumExceptionMessages;
import com.util.city_api.core.exception.abstracts.BaseExceptionModel;
import org.springframework.http.HttpStatus;

import static com.util.city_api.core.constant.CoreConstantExceptionErrorCode.*;

public class UnSuccessfulException extends BaseExceptionModel {
    public UnSuccessfulException(CoreEnumExceptionMessages coreEnumExceptionMessages,
    		                     String errorDetailCode, 
                                 String errorDescription) {
                                 super(coreEnumExceptionMessages,
                                       B_UN_SUCCESSFUL_EXCEPTION_ERROR_CODE,
                                       errorDetailCode,
                                       errorDescription,
                                       HttpStatus.NOT_ACCEPTABLE);}}
