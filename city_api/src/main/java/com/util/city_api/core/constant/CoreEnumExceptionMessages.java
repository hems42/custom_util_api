package com.util.city_api.core.constant;

import static com.util.city_api.core.constant.CoreConstantExceptionErrorCode.*;

public enum CoreEnumExceptionMessages {
 

    //AUTHENTICATION***
        
     // ACCESS TOKEN
    NOT_VALID_ACCESS_TOKEN("ACCESS_TOKEN_EXPIRED",T_ACCESS_TOKEN),

    //T_LOGIN
    UN_SUCCESSFUL_RENEW_REFRESH_TOKEN("UN_SUCCESSFUL_RENEW_REFRESH_TOKEN",T_REFRESH_TOKEN),
    
     //T_REGISTRATION
    UN_SUCCESSFUL_REGISTRATION("UN_SUCCESSFUL_REGISTRATION",T_REGISTRATION),

    
     //T_SIGNUP
    UN_SUCCESSFUL_SIGNUP("UN_SUCCESSFUL_SIGNUP",T_SIGNUP),

     //T_LOGIN
    UN_SUCCESSFUL_LOGIN("UN_SUCCESSFUL_LOGIN",T_LOGIN);








    private String exceptionMessage;
    private String exceptionCode;

    CoreEnumExceptionMessages(String exceptionMessage, String exceptionCode) {
        this.exceptionMessage = exceptionMessage;
        this.exceptionCode = exceptionCode;
    }

    public void setExceptionCode(String exceptionCode) {
        this.exceptionCode = exceptionCode;
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }

    public String getExceptionCode() {
        return exceptionCode;
    }
	
}
