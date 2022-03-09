package com.util.city_api.product_core.dtoConvertor;

import org.springframework.stereotype.Component;

import com.util.city_api.entity.log.LogUser;
import com.util.city_api.product_core.dto.logDto.LogUserDto;

@Component
public class LogUserDtoConvertor {

	public LogUser convert(LogUserDto from) {
		return new LogUser(
				from.getLogUserId(),
				from.getTransactionType(),
				from.getPerformingTransactionBy(),
				from.getUser(),
				from.getCreatedDate() == null ? null : from.getCreatedDate()
				);
	}

	public LogUserDto convert(LogUser from) {
		return new LogUserDto(
				from.getLogUserId(),
				from.getTransactionType(),
				from.getPerformingTransactionBy(),
				from.getUser(),
				from.getCreatedDate() == null ? null : from.getCreatedDate()
				);
	}

}
