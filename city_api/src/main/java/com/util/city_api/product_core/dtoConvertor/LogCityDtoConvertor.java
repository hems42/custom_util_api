package com.util.city_api.product_core.dtoConvertor;

import org.springframework.stereotype.Component;

import com.util.city_api.entity.log.LogCity;
import com.util.city_api.product_core.dto.logDto.LogCityDto;

@Component
public class LogCityDtoConvertor {

	public LogCity convert(LogCityDto from) {
		return new LogCity(
				from.getLogCityId(),
				from.getTransactionType(),
				from.getCity(),
				from.getPerformingTransactionBy(),
				from.getCreatedDate() == null ? null : from.getCreatedDate()
				);
	}

	public LogCityDto convert(LogCity from) {
		return new LogCityDto(
				from.getLogCityId(),
				from.getTransactionType(),
				from.getCity(),
				from.getPerformingTransactionBy(),
				from.getCreatedDate() == null ? null : from.getCreatedDate()
				
				);
	}

}
