package com.util.city_api.baseMockModel;

import java.time.LocalDateTime;
import java.util.HashSet;

import com.util.city_api.entity._core.*;
import com.util.city_api.entity.log.*;
import com.util.city_api.product_core.dto._coreDto.*;
import com.util.city_api.product_core.dto.logDto.*;

public class BaseEntityAndDtoTestModel {

   // utilities...................
   public LocalDateTime getTime()
	{
		return LocalDateTime.of(2013, 11, 30, 22, 32, 34, 0);
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
   
   
   
   
   //----------------------
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

   public RoleDto getRoleDto()
   {
	   return new RoleDto (
			   null,
			   "roleName",
			   "rolDescription",
			   getTime(),
			   getTime()
			   );
   }
  
   
   //------------------------------
   public Territory getTerritory()
   {
	   return new Territory();
   }
   
   public TerritoryDto getTerritoryDto()
   {
	   return new TerritoryDto();
   }
   
   public City getCity()
   {
	   return new City();
   }
   
   public CityDto getCityDto()
   {
	   return new CityDto();
   }
   
   public District getDistrict()
   {
	   return new District();
   }

   public DistrictDto getDistrictDto()
   {
	   return new DistrictDto();
   }
   
   public Town getTown()
   {
	   return new Town();
   }

   public TownDto getTownDto()
   {
	   return new TownDto();
   }


   //------------------------------------
   public LogTerritory getLogTerritory()
   {
	   return new LogTerritory();
   }
   
   public LogTerritoryDto getLogTerritoryDto()
   {
	   return new LogTerritoryDto();
   }
   
   public LogCity getLogCity()
   {
	   return new LogCity();
   }
   
   public LogCityDto getLogCityDto()
   {
	   return new LogCityDto();
   }
   
   public LogDistrict getLogDistrict()
   {
	   return new LogDistrict();
   }

   public LogDistrictDto getLogDistrictDto()
   {
	   return new LogDistrictDto();
   }
   
   public LogTown getLogTown()
   {
	   return new LogTown();
   }

   public LogTownDto getLogTownDto()
   {
	   return new LogTownDto();
   }

   }
