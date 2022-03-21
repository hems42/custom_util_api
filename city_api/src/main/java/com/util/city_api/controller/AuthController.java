package com.util.city_api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.util.city_api.core.constant.CoreEnumExceptionMessages;
import com.util.city_api.core.exception.exceptionModels.UnSuccessfulException;
import com.util.city_api.product_core.dto._coreDto.UserDto;
import com.util.city_api.product_core.request.createRequest.UserCreateRequest;
import com.util.city_api.service._abstract.IUserService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	private final IUserService userService;
	
	public AuthController(IUserService userService) {
		this.userService = userService;
	}


	@PostMapping("/signUp")
	    public ResponseEntity<?> signup(UserCreateRequest userCreateRequest) {
              
		   UserDto userDto = userService.createUser(userCreateRequest);
		   
		   	if(userDto!=null)
		   	{
		   		return ResponseEntity.ok(userDto);
		   	}
		   	else {
		   		
		   		throw new UnSuccessfulException(CoreEnumExceptionMessages.UN_SUCCESSFUL_CREATED_USER,"user did not cerated beacause : ");
		   	}
	   
	    	
	    }}
