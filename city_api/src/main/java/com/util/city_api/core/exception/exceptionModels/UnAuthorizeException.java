package com.util.city_api.core.exception.exceptionModels;

import org.springframework.http.HttpStatus;

import com.util.city_api.core.constant.CoreEnumExceptionMessages;
import com.util.city_api.core.exception.abstracts.BaseExceptionModel;

import static com.util.city_api.core.constant.CoreExceptionErrorCodeConstants.*;

public class UnAuthorizeException extends BaseExceptionModel {

    public UnAuthorizeException(CoreEnumExceptionMessages coreEnumExceptionMessages,
                                String errorDescription) {
        super(coreEnumExceptionMessages,
                UN_AUTHORIZE_EXCEPTION_ERROR_CODE,
                errorDescription,
                HttpStatus.UNAUTHORIZED);
    }
}