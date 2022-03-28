package com.util.city_api.service.concrete;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import com.util.city_api.core.constant.CoreEnumExceptionMessages;
import com.util.city_api.core.exception.exceptionModels.NotFoundException;
import com.util.city_api.dao.UserDao;
import com.util.city_api.entity._core.User;
import com.util.city_api.product_core.dto._coreDto.UserDto;
import com.util.city_api.product_core.dtoConvertor.UserDtoConvertor;
import com.util.city_api.product_core.enums.RoleTypes;
import com.util.city_api.product_core.request.createRequest.UserCreateRequest;
import com.util.city_api.product_core.request.updateRequest.UserUpdateRequest;
import com.util.city_api.service._abstract.ILogUserService;
import com.util.city_api.service._abstract.IUserService;

import static com.util.city_api.product_core.enums.EnumLogOperations.*; 

@Service
public class UserService implements IUserService{
	
	private final UserDao userRepository;
	
	private final UserDtoConvertor userDtoConvertor;
	
	private final ILogUserService logUserService;

	public UserService(UserDao userRepository, UserDtoConvertor userDtoConvertor, ILogUserService logUserService) {
		this.userRepository = userRepository;
		this.userDtoConvertor = userDtoConvertor;
		this.logUserService = logUserService;
	}

	
	
	// CREATE
	
	@Override
	public UserDto createUser(UserCreateRequest createRequest) {
		
		if(!isExistUser(createRequest.getUserName(), createRequest.getEMail())) {
		 
			User user = userRepository.save(new User(null, 
				 createRequest.getUserName(),
				 createRequest.getEMail(),
				 createRequest.getPassword(),
				 true,
				 false,
				 false,
				 null,
				 LocalDateTime.now(),
				 null));
		 
		    if(user!=null) {
		    	logUserService.addLogToUser(CREATED, user);}
		    else {
		    	return null;}	
		    
		    return userDtoConvertor.convert(user);
		}
		else {
			
		 return null;	
		
		}
		
	}


	// SELECT
	
	@Override
	public UserDto getUserById(String userId) {
		return userDtoConvertor.convert(userRepository.getById(userId));
	}

	@Override
	public UserDto getUserByUserName(String userName) {
		return userDtoConvertor.convert(userRepository.getUserByNickName(userName));
	}

	@Override
	public UserDto getUserByEmail(String email) {
		return userDtoConvertor.convert(userRepository.getUserByEmail(email));
	}

	@Override
	public List<UserDto> getAllUsers() {
		return userRepository.findAll().stream().map(t -> userDtoConvertor.convert(t)).collect(Collectors.toList());
	}

	@Override
	public List<UserDto> getAllUsersByIsActive(Boolean isActive) {
		return userRepository.getAllUsersByIsActive(isActive).stream().map(t -> userDtoConvertor.convert(t)).collect(Collectors.toList());
	}

	@Override
	public List<UserDto> getAllUsersByIsBlocked(Boolean isBlocked) {
		return userRepository.getAllUsersByIsBlocked(isBlocked).stream().map(t -> userDtoConvertor.convert(t)).collect(Collectors.toList());
	}

	@Override
	public List<UserDto> getAllUsersByIsRegistered(Boolean isRegistered) {
		return userRepository.getAllUsersByIsRegistered(isRegistered).stream().map(t -> userDtoConvertor.convert(t)).collect(Collectors.toList());
	}

	@Override
	public List<UserDto> getAllUsersByRoleType(RoleTypes roleType) {
		// TODO Auto-generated method stub
		return null;
	}

	
	// UPDATE
	
	@Override
	public UserDto updateUser(UserUpdateRequest updateRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	
	// DELETE
	
	@Override
	public Boolean deleteUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteUserById(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteUserByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public UserDto updateUserName(String userName) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public UserDto updatePassword(String password) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public UserDto updateUserIsActive(Boolean isActive) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public UserDto updateUserIsBlocked(Boolean isBlocked) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public UserDto updateUserIsRegistered(Boolean isRegistered) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Boolean isExistUserById(String userId) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Boolean isExistUserByUserName(String userName) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Boolean isExistUserByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Boolean isRegisteredUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Boolean isActiveUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Boolean isBlockedUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Integer getCountAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Integer getCountUserByIsActive(Boolean isActive) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Integer getCountUserByIsRegistered(Boolean isRegistered) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Integer getCountUserByIsBlocked(Boolean isBlocked) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Integer getCountUserByHasRoleType(RoleTypes roleType) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	// isCHECK
	

	
	
	
	
	
	
	
	
	//COUNT
	
	
	
	
	
	// UTILTY...
	
	private Boolean isExistUser(@Nullable String userName, @Nullable String email) {
		User user = userRepository.getUserByNickNameOrEmail(userName, userName);	
		return user != null;
	}
	
	private Boolean isExistUserWithException(@Nullable String userName, @Nullable String email) {
		User user = userRepository.getUserByNickNameOrEmail(userName, userName);	
		
		if(user==null)
		{
			throw new NotFoundException(CoreEnumExceptionMessages.NOT_FOUND_USER,"user not found");
		}
		
		return true;
	}

}
