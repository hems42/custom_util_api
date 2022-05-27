package com.util.city_api.controller;

import org.springframework.web.bind.annotation.RestController;

import com.util.city_api.core.constant.CoreConstantExceptionErrorCode;
import com.util.city_api.core.constant.CoreEnumExceptionMessages;
import com.util.city_api.core.exception.exceptionModels.UnSuccessfulException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/city")
public class CityController {

    @GetMapping("/dene")
    public ResponseEntity<?> signup() {
 
   
    	 throw new UnSuccessfulException(CoreEnumExceptionMessages.UN_SUCCESSFUL_SIGNUP,CoreConstantExceptionErrorCode.D_EMAIL_ALREADY_USED, "email adresi daha önce kullanılmış");
    	
    	//return ResponseEntity.ok("anan anan ...");
    }
	
}
