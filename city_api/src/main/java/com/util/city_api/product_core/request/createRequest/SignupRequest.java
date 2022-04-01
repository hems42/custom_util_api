package com.util.city_api.product_core.request.createRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignupRequest {
	
	String username;
	String email;	
	String password;
    String platformType;
}
