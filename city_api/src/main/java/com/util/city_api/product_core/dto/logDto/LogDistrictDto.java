package com.util.city_api.product_core.dto.logDto;

import java.time.LocalDateTime;

import com.util.city_api.entity._core.District;
import com.util.city_api.entity._core.User;
import com.util.city_api.product_core.enums.EnumLogOperations;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LogDistrictDto {

	private String logDistrictId;

    private EnumLogOperations transactionType;

    private District district;

    private User PerformingTransactionBy;

    private LocalDateTime createdDate;
}
