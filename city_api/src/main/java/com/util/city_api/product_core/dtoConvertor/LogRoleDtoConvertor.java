package com.util.city_api.product_core.dtoConvertor;

import org.springframework.stereotype.Component;

import com.util.city_api.entity.log.LogRole;
import com.util.city_api.product_core.dto.logDto.LogRoleDto;

@Component
public class LogRoleDtoConvertor {

	public LogRole convert(LogRoleDto from) {
		return new LogRole(
				from.getLogRoleId(),
				from.getTransactionType(),
				from.getRole(),
				from.getPerformingTransactionBy(),
				from.getCreatedDate() == null ? null : from.getCreatedDate()
				);
	}

	public LogRoleDto convert(LogRole from) {
		return new LogRoleDto(
				from.getLogRoleId(),
				from.getTransactionType(),
				from.getRole(),
				from.getPerformingTransactionBy(),
				from.getCreatedDate() == null ? null : from.getCreatedDate()
				);
	}

}
