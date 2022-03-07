package com.util.city_api.core.exception.exceptionModels;

import com.util.city_api.core.constant.CoreEnumExceptionMessages;
import com.util.city_api.core.exception.abstracts.BaseExceptionModel;
import org.springframework.http.HttpStatus;

import static com.util.city_api.core.constant.CoreExceptionErrorCodeConstants.*;

public class UnSuccessfulException extends BaseExceptionModel {
    public UnSuccessfulException(CoreEnumExceptionMessages coreEnumExceptionMessages,
                                 String errorDescription) {
        super(coreEnumExceptionMessages,
                UN_SUCCESSFUL_EXCEPTION_ERROR_CODE,
                errorDescription,
                HttpStatus.NOT_ACCEPTABLE);
    }
}
