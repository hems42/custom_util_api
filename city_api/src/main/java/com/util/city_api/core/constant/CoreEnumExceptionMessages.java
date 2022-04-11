package com.util.city_api.core.constant;

import static com.util.city_api.core.constant.CoreConstantExceptionErrorCode.*;

public enum CoreEnumExceptionMessages {
 

    //AUTHENTICATION***
        
     // ACCESS TOKEN
    NOT_VALID_ACCESS_TOKEN("ACCESS_TOKEN_EXPIRED",ACCESS_TOKEN),
    NOT_FOUND_ACCESS_TOKEN("ACCESS_TOKEN_NOT_FOUND",""),


    
    
    //REFRESH TOKEN
    NOT_VALID_REFRESH_TOKEN_EXPIRED("REFRESH_TOKEN_EXPIRED",""),
    NOT_FOUND_REFRESH_TOKEN("REFRESH_TOKEN_NOT_FOUND",""),
    ALREADY_EXIST_REFRESH_TOKEN("REFRESH_TOKEN_ALREADY_EXIST",""),
    UN_SUCCESSFUL_CREATED_REFRESH_TOKEN("UN_SUCCESSFUL_CREATED_REFRESH",""),
    UN_SUCCESSFUL_SAVED_REFRESH_TOKEN("UN_SUCCESSFUL_SAVED_REFRESH_TOKEN",""),
    UN_SUCCESSFUL_DELETED_REFRESH_TOKEN("UN_SUCCESSFUL_DELETED_REFRESH_TOKEN",""),


    
    //CONFIRMATION TOKEN
    NOT_VALID_CONFIRMATION_TOKEN_EXPIRED("CONFIRMATION_TOKEN_EXPIRED",""),
    NOT_FOUND_CONFIRMATION_TOKEN("CONFIRMATION_TOKEN_NOT_FOUND",""),
    ALREADY_ACCEPTED_CONFIRMATION_TOKEN_CONFIRMED("CONFIRMATION_ALREADY_CONFIRMED",""),
    UN_SUCCESSFUL_CONFIRMATION_TOKEN_CONFIRMED("CONFIRMATION_TOKEN_NOT_CONFIRMED",""),



    //EMAIL
    NOT_VALID_E_MAIL_ADDRESS("E_MAIL_ADDRESS_NOT_VALID",""),
    NOT_FOUND_E_MAIL_ADDRESS("E_MAIL_ADDRESS_NOT_FOUND",""),
    ALREADY_ACCEPTED_E_MAIL_ADDRESS("E_MAIL_ADDRESS_ALREADY_ACCEPTED",""),


    //REGISTRATION
    UN_SUCCESSFUL_REGISTRATION("USER_NOT_CONFIRMED",""),

    
    //SIGNUP
    UN_SUCCESSFUL_SIGNUP("UN_SUCCESSFUL_SIGNUP",SIGNUP),

    
 
    //ENTITY***
      //ROLE
    ALREADY_EXIST_ROLE("ROLE_ALREADY_EXIST", ""),
    NOT_FOUND_ROLE("ROLE_NOT_FOUND", ""),
    UN_SUCCESSFUL_CREATED_ROLE("ROLE_NOT CREATED", ""),



      //USER
    NOT_FOUND_USER("USER_NOT_FOUND",""),
    ALREADY_EXIST_USER("USER_ALREADY_EXIST",""),
    UN_SUCCESSFUL_CREATED_USER("USER_NOT CREATED", ""),


      //LOGIN
    UN_ACCEPTABLE_LOGIN_REQUEST("LOGIN REQUEST UNACCEPTABLE","");
























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
