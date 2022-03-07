package com.util.city_api.baseMockModel;

import java.time.LocalDateTime;
import java.util.HashSet;

import com.util.city_api.entity._core.*;
import com.util.city_api.entity.log.*;
import com.util.city_api.product_core.dto._coreDto.*;
import com.util.city_api.product_core.dto.logDto.*;

import static com.util.city_api.product_core.enums.EnumLogOperatıons.*;

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
	   return new Territory(
			   null,
			   "territorName",
			   "territoryDescription",
			   getTime(),
			   getTime()
			   );
   }
   
   public TerritoryDto getTerritoryDto()
   {
	   return new TerritoryDto(
			   null,
			   "territorName",
			   "territoryDescription",
			   getTime(),
			   getTime()
			   );
   }
   
   public City getCity()
   {
	   return new City(
			   null,
			   getTerritory(),
			   "cityName",
			   "plateCode",
			   "postCode",
			   "phoneNumberCode",
			   "cityDescription",
			   getTime(),
			   getTime()
			   );
   }
   
   public CityDto getCityDto()
   {
	   return new CityDto(
			   null,
			   getTerritory(),
			   "cityName",
			   "plateCode",
			   "postCode",
			   "phoneNumberCode",
			   "cityDescription",
			   getTime(),
			   getTime()			   
			   );
   }
   
   public District getDistrict()
   {
	   return new District(
			   null,
			   getCity(),
			   "districtName",
			   "postCode",
			   "districtDescription",
			   getTime(),
			   getTime()
			   );
   }

   public DistrictDto getDistrictDto()
   {
	   return new DistrictDto(
			   null,
			   getCity(),
			   "districtName",
			   "postCode",
			   "districtDescription",
			   getTime(),
			   getTime()
			   );
   }
   
   public Town getTown()
   {
	   return new Town(
			   null,
			   getDistrict(),
			   "townName",
			   "townDescription",
			   getTime(),
			   getTime()
			   );
   }

   public TownDto getTownDto()
   {
	   return new TownDto(
			   null,
			   getDistrict(),
			   "townName",
			   "townDescription",
			   getTime(),
			   getTime()
			   );
   }


   //------------------------------------
   public LogTerritory getLogTerritory()
   {
	   return new LogTerritory(
			   null,
			   CREATED,
			   getTerritory(),
			   getUser(),
			   getTime()
			   );
   }
   
   public LogTerritoryDto getLogTerritoryDto()
   {
	   return new LogTerritoryDto(
			   null,
			   CREATED,
			   getTerritory(),
			   getUser(),
			   getTime()
			   );
   }
   
   public LogCity getLogCity()
   {
	   return new LogCity(
			   null,
			   CREATED,
			   getCity(),
			   getUser(),
			   getTime()
			   );
   }
   
   public LogCityDto getLogCityDto()
   {
	   return new LogCityDto(
			   null,
			   CREATED,
			   getCity(),
			   getUser(),
			   getTime()
			   );
   }
   
   public LogDistrict getLogDistrict()
   {
	   return new LogDistrict(
			   null,
			   CREATED,
			   getDistrict(),
			   getUser(),
			   getTime()
			   );
   }

   public LogDistrictDto getLogDistrictDto()
   {
	   return new LogDistrictDto(
			   null,
			   CREATED,
			   getDistrict(),
			   getUser(),
			   getTime()
			   );
   }
   
   public LogTown getLogTown()
   {
	   return new LogTown(
			   null,
			   CREATED,
			   getTown(),
			   getUser(),
			   getTime()
			   );
   }

   public LogTownDto getLogTownDto()
   {
	   return new LogTownDto(
			   null,
			   CREATED,
			   getTown(),
			   getUser(),
			   getTime()
			   );
   }

   }
