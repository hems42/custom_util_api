package com.util.city_api.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.util.city_api.dao.UserDao;
import com.util.city_api.product_core.dtoConvertor.UserDtoConvertor;
import com.util.city_api.service._abstract.ILogUserService;
import com.util.city_api.service._abstract.IUserService;
import com.util.city_api.service.concrete.LogUserService;
import com.util.city_api.service.concrete.UserService;

public class UserServiceTest {

	UserDao userRepository;
	UserDtoConvertor userDtoConvertor;
	ILogUserService logUserService;
	
	IUserService userService;
	@BeforeEach
	void setup()
	{
		userRepository = Mockito.mock(UserDao.class);
		userDtoConvertor  = Mockito.mock(UserDtoConvertor.class);
		logUserService = Mockito.mock(LogUserService.class);
		
		userService = new UserService(
				userRepository,
				userDtoConvertor,
				logUserService);
	}
	
	@Test
	void When()
	{
		
	}
	
}
