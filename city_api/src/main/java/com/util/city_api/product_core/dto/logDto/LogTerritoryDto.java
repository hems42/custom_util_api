package com.util.city_api.product_core.dto.logDto;

import java.time.LocalDateTime;

import com.util.city_api.entity._core.Territory;
import com.util.city_api.entity._core.User;
import com.util.city_api.product_core.enums.EnumLogOperatıons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LogTerritoryDto {
	
	private String logTerritoryId;

    private EnumLogOperatıons transactionType;

    private Territory territory;

    private User PerformingTransactionBy;

    private LocalDateTime createdDate;

}
