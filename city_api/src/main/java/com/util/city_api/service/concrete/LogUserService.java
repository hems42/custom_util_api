package com.util.city_api.service.concrete;

import java.util.List;

import org.springframework.stereotype.Service;

import com.util.city_api.dao.LogUserDao;
import com.util.city_api.entity.primary.User;
import com.util.city_api.product_core.dto.logDto.LogUserDto;
import com.util.city_api.product_core.enums.EnumLogOperations;
import com.util.city_api.service._abstract.ILogUserService;

@Service
public class LogUserService implements ILogUserService{

	private final LogUserDao logUserDao;
	
	public LogUserService(LogUserDao logUserDao) {
		this.logUserDao = logUserDao;
	}
	
	// CREATE
	
	@Override
	public LogUserDto addLogToUser(EnumLogOperations logType, User user) {
		return null;
	}

	
	// SELECT
	
	@Override
	public LogUserDto getLogById(String logId) {
		return null;
	}

	@Override
	public List<LogUserDto> getAllLog() {
		return null;
	}

	@Override
	public List<LogUserDto> getAllLogByLogType(EnumLogOperations logtype) {
		return null;
	}

	@Override
	public List<LogUserDto> getAllLogByUser(User user) {
		return null;
	}

	@Override
	public List<LogUserDto> getAllLogByPerformeduser(User user) {
		return null;
	}

}
