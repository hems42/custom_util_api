package com.util.city_api.core.constant;

public class CoreConstantExceptionErrorCode {

    /*
    
    
    CUSTOM EXCEPTION CODES:
    
   //******************************************************************
    
    Error_MainGroupCodeList :
    
    - UN                      : 10
    - ALREADY                 : 20
    - NOT                     : 30
    - NON                     : 40
    - FORBIDDEN               : 50
    
    
    
    
   //*****************************************************************
    
    Error_SubGroupCodeList :
    
     - EXIST                  : 10
     - VALID                  : 20
     - FOUND                  : 30
     - SUCCESS                : 40
     - ACCEPT                 : 50
     - AUTHORIZE              : 60
     
	
   //******************************************************************
    
    Error_EntityCodeList :
    
      - USER                  : 010
      - ROLE                  : 020
      - REQUEST               : 030
      - REFRESH TOKEN         : 040
      - CONFIRMATION TOKEN    : 050
      - ACCESS TOKEN          : 060
      - REGISTRATION          : 070
      - LOGIN                 : 080
      - EMAIL                 : 090 
      - SIGNUP                : 100
      - LOGIN                 : 101
      - LOGOUT                : 102
           
     
   //******************************************************************
    
    Error_EventCodeList :
    
     
     
    
     */
	
	
	//-Error_MainGroupCodeList :
	
	private final static String UN                            = "10";
	private final static String ALREADY                       = "20";
	private final static String NOT                           = "30";
	private final static String NON                           = "40";
	private final static String FORBIDDEN                     = "50";
	
	
	//-Error_SubGroupCodeList :
	
	private final static String EXIST                          = "10";
    private final static String VALID                          = "20";
    private final static String FOUND                          = "30";
    private final static String SUCCESS                        = "40";
    private final static String ACCEPT                         = "50";
    private final static String AUTHORIZE                      = "60";

    
    
    //-Error_EntityCodeList :
    
    public final static String USER                            = "010";
    public final static String ROLE                            = "020";
    public final static String REQUEST                         = "030";
    public final static String REFRESH_TOKEN                   = "040";
    public final static String CONFIRMATION_TOKEN              = "050";
    public final static String ACCESS_TOKEN                    = "060";
    public final static String REGISTRATION                    = "070";
    public final static String EMAIL                           = "080";
    public final static String SIGNUP                          = "090";
    public final static String LOGIN                           = "091";
    public final static String LOGOUT                          = "092";
    
    
     
    //-Error_ExceptionMessageCodeList :
    
    public static String NOT_FOUND_EXCEPTION_ERROR_CODE                      = NOT + FOUND;
    public static String ALREADY_EXIST_EXCEPTION_ERROR_CODE                  = ALREADY + EXIST;
    public static String ALREADY_ACCEPTED_EXCEPTION_ERROR_CODE               = ALREADY + ACCEPT;
    public static String FORBIDDEN_EXCEPTION_ERROR_CODE                      = FORBIDDEN + "00";
    public static String UN_AUTHORIZE_EXCEPTION_ERROR_CODE                   = UN + AUTHORIZE;
    public static String UN_SUCCESSFUL_EXCEPTION_ERROR_CODE                  = UN + SUCCESS;
    public static String UN_ACCEPTABLE_EXCEPTION_ERROR_CODE                  = UN + ACCEPT;
    public static String NOT_VALID_EXCEPTION_ERROR_CODE                      = NOT +VALID;

    
    
    //-Error_EventCodeList :

    public static String EMAIL_ALREADY_USED                                  = "0001";
    public static String USERNAME_ALREADY_USED                               = "0002";
    public static String EMAIL_AND_USERNAME_ALREADY_USED                     = "0003";
    
    // USER
    public static String USER_NOT_CREATED                                    = "0010"; 
    public static String USER_ALREADY_REGISTERED                             = "0011";
    public static String USER_NOT_REGISTERED                                 = "0012";
    public static String USER_NOT_FOUND                                      = "0013";
    public static String USER_NOT_ACTIVE                                     = "0014";
    public static String USER_ALREADY_LOGIN                                  = "0015";
    
    
    // AUTHENTICATION
    public static String ACCESS_TOKEN_NOT_CREATED_OR_SAVED                   = "0020";
    public static String ACCESS_TOKEN_STILL_VALID                            = "0021";
    public static String REFRESH_TOKEN_NOT_CREATED_OR_SAVED                  = "0024";
    public static String REFRESH_TOKEN_NOT_FOUND                             = "0025";
    public static String REFRESH_TOKEN_NOT_VALID                             = "0026";
    public static String CONFIRMATION_TOKEN_NOT_CREATED_OR_SAVED             = "0030";
    public static String CONFIRMATION_TOKEN_NOT_FOUND                        = "0031";
    public static String CONFIRMATION_TOKEN_EXPIRED                          = "0032";
    public static String CONFIRMATION_TOKEN_ALREADY_USED                     = "0033";
    public static String CONFIRMATION_TOKEN_NOT_REGISTERED                   = "0034";


    

}
