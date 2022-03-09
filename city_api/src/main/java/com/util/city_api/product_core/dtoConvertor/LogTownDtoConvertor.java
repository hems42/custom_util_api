package com.util.city_api.product_core.dtoConvertor;

import org.springframework.stereotype.Component;

import com.util.city_api.entity.log.LogTown;
import com.util.city_api.product_core.dto.logDto.LogTownDto;

@Component
public class LogTownDtoConvertor {

	public LogTown convert(LogTownDto from) {
		return new LogTown(
				from.getLogTownId(),
				from.getTransactionType(),
				from.getTown(),
				from.getPerformingTransactionBy(),
				from.getCreatedDate() == null ? null : from.getCreatedDate()
				);
	}

	public LogTownDto convert(LogTown from) {
		return new LogTownDto(
				from.getLogTownId(),
				from.getTransactionType(),
				from.getTown(),
				from.getPerformingTransactionBy(),
				from.getCreatedDate() == null ? null : from.getCreatedDate()
				);
	}

}
