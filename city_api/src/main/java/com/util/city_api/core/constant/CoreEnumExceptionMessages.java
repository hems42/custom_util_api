package com.util.city_api.core.constant;

import static com.util.city_api.core.constant.CoreConstantExceptionErrorCode.*;

public enum CoreEnumExceptionMessages {
 

    //AUTHENTICATION***
        
     // ACCESS TOKEN
    NOT_VALID_ACCESS_TOKEN("ACCESS_TOKEN_EXPIRED",ACCESS_TOKEN),


     //REGISTRATION
    UN_SUCCESSFUL_REGISTRATION("UN_SUCCESSFUL_REGISTRATION",REGISTRATION),

    
     //SIGNUP
    UN_SUCCESSFUL_SIGNUP("UN_SUCCESSFUL_SIGNUP",SIGNUP),

     //LOGIN
    UN_SUCCESSFUL_LOGIN("UN_SUCCESSFUL_LOGIN",LOGIN);








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
