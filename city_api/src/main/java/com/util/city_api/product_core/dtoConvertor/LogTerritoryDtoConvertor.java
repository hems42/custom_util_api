package com.util.city_api.product_core.dtoConvertor;

import org.springframework.stereotype.Component;

import com.util.city_api.entity.log.LogTerritory;
import com.util.city_api.product_core.dto.logDto.LogTerritoryDto;

@Component
public class LogTerritoryDtoConvertor {

	public LogTerritory convert(LogTerritoryDto from) {
		return new LogTerritory(
				from.getLogTerritoryId(),
				from.getTransactionType(),
				from.getTerrritory(),
				from.getPerformingTransactionBy(),
				from.getCreatedDate() == null ? null : from.getCreatedDate()
				);
	}

	public LogTerritoryDto convert(LogTerritory from) {
		return new LogTerritoryDto(
				from.getLogTerritoryId(),
				from.getTransactionType(),
				from.getTerritory(),
				from.getPerformingTransactionBy(),
				from.getCreatedDate() == null ? null : from.getCreatedDate()
				);
	}

}
