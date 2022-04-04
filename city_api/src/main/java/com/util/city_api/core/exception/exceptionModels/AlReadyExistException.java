package com.util.city_api.core.exception.exceptionModels;

import org.springframework.http.HttpStatus;

import com.util.city_api.core.constant.CoreEnumExceptionMessages;
import com.util.city_api.core.exception.abstracts.BaseExceptionModel;

import static com.util.city_api.core.constant.CoreConstantExceptionErrorCode.*;

public class AlReadyExistException extends BaseExceptionModel {
    public AlReadyExistException(CoreEnumExceptionMessages coreEnumExceptionMessages, String errorDescription) {
        super(coreEnumExceptionMessages,
                ALREADY_EXIST_EXCEPTION_ERROR_CODE,
                errorDescription,
                HttpStatus.EXPECTATION_FAILED);
    }
}
