package com.util.city_api.product_core.dto.logDto;

import java.time.LocalDateTime;

import com.util.city_api.entity.primary.Role;
import com.util.city_api.entity.primary.User;
import com.util.city_api.product_core.enums.EnumLogOperations;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LogRoleDto {
	
	private String logRoleId;

    private EnumLogOperations transactionType;

    private Role role;

    private User PerformingTransactionBy;

    private LocalDateTime createdDate;
    
}
