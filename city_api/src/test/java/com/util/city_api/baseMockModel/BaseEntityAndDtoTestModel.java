package com.util.city_api.baseMockModel;

import java.time.LocalDateTime;
import java.util.HashSet;

import com.util.city_api.entity._core.Role;
import com.util.city_api.entity._core.User;
import com.util.city_api.product_core.dto._coreDto.UserDto;

public class BaseEntityAndDtoTestModel {

   public LocalDateTime getTime()
	{
		return LocalDateTime.of(2013, 11, 30, 22, 32, 34, 0);
	}
   
   public Role getRole()
   {
	   return new Role (
			   null,
			   "roleName",
			   "rolDescription",
			   getTime(),
			   getTime()
			   );
   }

   public HashSet<Role> getRoleList()
   {
	  HashSet<Role> roles = new HashSet<Role>();
	  
	  roles.add(getRole());
	  
	  roles.add(getRole());
	  
	  roles.add(getRole());
	  
	  roles.add(getRole());
	  
	  roles.add(getRole());
	   
	   return roles;
   }
   
   public User getUser() {
		return new User(
				null,
				"userName",
				"email",
				"password",
				true,
				true,
				true,
				getRoleList(),
				getTime(),
				getTime()
				);
	}
   
   public UserDto getUserDto()
   {
	   return new UserDto(
				null,
				"userName",
				"email",
				"password",
				true,
				true,
				true,
				getRoleList(),
				getTime(),
				getTime()
			   );
   }




}
