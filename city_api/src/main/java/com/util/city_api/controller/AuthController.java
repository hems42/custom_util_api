package com.util.city_api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.util.city_api.core.constant.CoreConstantExceptionErrorCode;
import com.util.city_api.core.constant.CoreEnumExceptionMessages;
import com.util.city_api.core.exception.exceptionModels.UnSuccessfulException;
import com.util.city_api.product_core.dto.primaryDto.UserDto;
import com.util.city_api.product_core.request.createRequest.SignupRequest;
import com.util.city_api.product_core.request.createRequest.UserCreateRequest;
import com.util.city_api.product_core.response.SignupReponse;
import com.util.city_api.service._abstract.IAuthService;
import com.util.city_api.service._abstract.IUserService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	private final IUserService userService;
	private final IAuthService authService;
	
	public AuthController(IUserService userService, IAuthService authService) {
		this.userService = userService;
		this.authService = authService;
	}


	@PostMapping("/signUp")
	    public ResponseEntity<?> signup(@RequestBody UserCreateRequest userCreateRequest) {
              
		
	SignupReponse response = authService.signup(new SignupRequest(
				userCreateRequest.getUserName(),
				userCreateRequest.getEMail(),
				userCreateRequest.getPassword(),
				""));
			  
		   		return ResponseEntity.ok(response);
		  
		  
	    }}
