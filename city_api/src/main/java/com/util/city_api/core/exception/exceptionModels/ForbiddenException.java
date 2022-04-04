package com.util.city_api.core.exception.exceptionModels;

import org.springframework.http.HttpStatus;

import com.util.city_api.core.constant.CoreEnumExceptionMessages;
import com.util.city_api.core.exception.abstracts.BaseExceptionModel;

import static com.util.city_api.core.constant.CoreConstantExceptionErrorCode.*;

public class ForbiddenException extends BaseExceptionModel {

    public ForbiddenException(CoreEnumExceptionMessages coreEnumExceptionMessages, String errorDescription) {
        super(coreEnumExceptionMessages,
                FORBIDDEN_EXCEPTION_ERROR_CODE,
                errorDescription,
                HttpStatus.FORBIDDEN); }
}
