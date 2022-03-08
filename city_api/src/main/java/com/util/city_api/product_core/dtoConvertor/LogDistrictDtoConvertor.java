package com.util.city_api.product_core.dtoConvertor;

import org.springframework.stereotype.Component;

import com.util.city_api.entity.log.LogDistrict;
import com.util.city_api.product_core.dto.logDto.LogDistrictDto;

@Component
public class LogDistrictDtoConvertor {

	public LogDistrict convert(LogDistrictDto from) {
		return new LogDistrict(
				from.getLogDistrictId(),
				from.getTransactionType(),
				from.getDistrict(),
				from.getPerformingTransactionBy(),
				from.getCreatedDate() == null ? null : from.getCreatedDate()
				);
	}

	public LogDistrictDto convert(LogDistrict from) {
		return new LogDistrictDto(
				from.getLogDistrictId(),
				from.getTransactionType(),
				from.getDistrict(),
				from.getPerformingTransactionBy(),
				from.getCreatedDate() == null ? null : from.getCreatedDate()
				);
	}

}
