package com.util.city_api.product_core.response;

import java.time.LocalDateTime;
import java.util.Set;

import com.util.city_api.entity._core.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor 
@AllArgsConstructor
public class LoginResponse {

	private String userId;
    private String userName;
    private String email;
    private Boolean isActive;
    private Boolean isRegistered;
    private Set<Role> roles;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    private String accessToken;
    private String refreshToken;
}
