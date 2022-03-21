package com.util.city_api.service._abstract;

import java.util.List;

import com.util.city_api.entity._core.User;
import com.util.city_api.product_core.dto.logDto.LogUserDto;
import com.util.city_api.product_core.enums.EnumLogOperations;

public interface ILogUserService {

	// create
	
	LogUserDto addLogToUser(EnumLogOperations logType, User user);
	
	
	//-----------
	
	
	
	// select 
	
	LogUserDto getLogById(String logId);
	
	List<LogUserDto> getAllLog();
	
	List<LogUserDto> getAllLogByLogType(EnumLogOperations logtype);
	
	List<LogUserDto> getAllLogByUser(User user);
	
	List<LogUserDto> getAllLogByPerformeduser(User user);
	
	
	//-----------
	
}
