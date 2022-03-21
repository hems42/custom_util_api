package com.util.city_api.product_core.dto.logDto;

import java.time.LocalDateTime;

import com.util.city_api.entity._core.Town;
import com.util.city_api.entity._core.User;
import com.util.city_api.product_core.enums.EnumLogOperations;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LogTownDto {
	
	private String logTownId;

    private EnumLogOperations transactionType;

    private Town town;

    private User PerformingTransactionBy;

    private LocalDateTime createdDate;

}
