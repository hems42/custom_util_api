package com.util.city_api.product_core.dto.logDto;

import java.time.LocalDateTime;

import com.util.city_api.entity.primary.Territory;
import com.util.city_api.entity.primary.User;
import com.util.city_api.product_core.enums.EnumLogOperations;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LogTerritoryDto {
	
	private String logTerritoryId;

    private EnumLogOperations transactionType;

    private Territory territory;

    private User PerformingTransactionBy;

    private LocalDateTime createdDate;

}
