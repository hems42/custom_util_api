package com.util.city_api.product_core.dto.logDto;

import java.time.LocalDateTime;

import com.util.city_api.entity.primary.City;
import com.util.city_api.entity.primary.User;
import com.util.city_api.product_core.enums.EnumLogOperations;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LogCityDto {

    private String logCityId;

    private EnumLogOperations transactionType;

    private City city;

    private User PerformingTransactionBy;

    private LocalDateTime createdDate; }
