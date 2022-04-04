package com.util.city_api.core.exception.exceptionModels;

import org.springframework.http.HttpStatus;

import com.util.city_api.core.constant.CoreEnumExceptionMessages;
import com.util.city_api.core.exception.abstracts.BaseExceptionModel;

import static com.util.city_api.core.constant.CoreConstantExceptionErrorCode.*;

public class NotFoundException extends BaseExceptionModel {
    public NotFoundException(CoreEnumExceptionMessages coreEnumExceptionMessages, String errorDescription) {
        super(coreEnumExceptionMessages,
                NOT_FOUND_EXCEPTION_ERROR_CODE,
                errorDescription,
                HttpStatus.NOT_FOUND);
    }
}
