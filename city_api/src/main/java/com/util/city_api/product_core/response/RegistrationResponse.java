package com.util.city_api.product_core.response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor 
@AllArgsConstructor
public class RegistrationResponse {
	
	    private String registryMessage;
	    private String email;
	    private String userNickName;
	    private LocalDateTime registredAt;
}
