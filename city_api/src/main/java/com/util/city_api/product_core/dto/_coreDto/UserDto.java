package com.util.city_api.product_core.dto._coreDto;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;


import com.util.city_api.entity._core.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
	
private String userId;
	
    private String userName;

    private String eMail;

    private String password;

    private Boolean isActive;

    private Boolean isBlocked;
    
    private Boolean isRegistered;

    private Set<Role> roles = new HashSet<>();

    private LocalDateTime createdDate;

    private LocalDateTime updatedDate;
}
