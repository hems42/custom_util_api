package com.util.city_api.service._abstract;

import java.util.List;

import com.util.city_api.entity._core.User;
import com.util.city_api.product_core.dto._coreDto.UserDto;
import com.util.city_api.product_core.enums.EnumRoleTypes;
import com.util.city_api.product_core.request.createRequest.UserCreateRequest;
import com.util.city_api.product_core.request.updateRequest.UserUpdateRequest;

public interface IUserService {
	
	// create
	UserDto createUser(UserCreateRequest createRequest);
	
	//----------
	
	// select	
	UserDto getUserById(String userId);
	
	UserDto getUserByUserName(String username);
	
	UserDto getUserByEmail(String email);
	
	List<UserDto> getAllUsers();
	
	List<UserDto> getAllUsersByIsActive(Boolean isActive);

	List<UserDto> getAllUsersByIsBlocked(Boolean isBlocked);
	
	List<UserDto> getAllUsersByIsRegistered(Boolean isRegistered);
	
	List<UserDto> getAllUsersByRoleType(EnumRoleTypes roleType);
		
	
	//----------
	
	// update
	UserDto updateUser(UserUpdateRequest updateRequest);
	
	UserDto updateUserName(String username);
	
	UserDto updatePassword(String password);
	
	UserDto updateUserIsActive(Boolean isActive);
	
	UserDto updateUserIsBlocked(Boolean isBlocked);
	
	UserDto updateUserIsRegistered(Boolean isRegistered);
	
	
	//----------
	
	//delete
	Boolean deleteUser(User user);

	Boolean deleteUserById(String userId);
	
	Boolean deleteUserByEmail(String email);
	

	//----------

	// isCheck
	Boolean isExistUserById(String userId);
	
	Boolean isExistUserByUserName(String username);
	
	Boolean isExistUserByEmail(String email);
	
	Boolean isRegisteredUser(User user);
	
	Boolean isActiveUser(User user);
	
	Boolean isBlockedUser(User user);
	
	//----------
	
	//count
	Integer getCountAllUsers();
	
	Integer getCountUserByIsActive(Boolean isActive);
	
	Integer getCountUserByIsRegistered(Boolean isRegistered);
	
	Integer getCountUserByIsBlocked(Boolean isBlocked);
	
	Integer getCountUserByHasRoleType(EnumRoleTypes roleType);
	
	
	
	//----------
	
	
}
