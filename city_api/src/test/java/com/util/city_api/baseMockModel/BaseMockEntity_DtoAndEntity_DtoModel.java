package com.util.city_api.baseMockModel;

import java.time.LocalDateTime;
import java.util.Set;

import org.mockito.Mockito;

import com.util.city_api.entity._core.*;
import com.util.city_api.entity.log.*;
import com.util.city_api.entity.security.ConfirmationToken;
import com.util.city_api.entity.security.RefreshToken;
import com.util.city_api.product_core.dto._coreDto.*;
import com.util.city_api.product_core.dto.logDto.*;

import static com.util.city_api.product_core.enums.EnumLogOperations.*;

public class BaseMockEntity_DtoAndEntity_DtoModel {
     
   //----------------------
   public User getUser(Set<Role> roles, LocalDateTime createdDateTime, LocalDateTime updatedDateTime) {
		return new User(
				null,
				"userName",
				"email",
				"password",
				true,
				true,
				true,
				roles,
				createdDateTime,
				updatedDateTime
				);
	}

   public User getMockUser() {
	   return Mockito.mock(User.class);
   }
   
   public UserDto getUserDto(Set<Role> roles, LocalDateTime createdDateTime, LocalDateTime updatedDateTime)
   {
	   return new UserDto(
				null,
				"userName",
				"email",
				"password",
				true,
				true,
				true,
				roles,
				createdDateTime,
				updatedDateTime
			   );
   }
 
   public UserDto getMockUserDto() {
	   return Mockito.mock(UserDto.class);
   }
   
   public Role getRole(LocalDateTime createdDateTime, LocalDateTime updatedDateTime)
   {
	   return new Role (
			   null,
			   "roleName",
			   "rolDescription",
			   createdDateTime,
			   updatedDateTime
			   );
   }

   public RoleDto getRoleDto(LocalDateTime createdDateTime, LocalDateTime updatedDateTime)
   {
	   return new RoleDto (
			   null,
			   "roleName",
			   "rolDescription",
			   createdDateTime,
			   updatedDateTime
			   );
   }
  
   public ConfirmationToken getConfirmationToken(User performingTransactionBy,
		   LocalDateTime createdDateTime,
		   LocalDateTime expiresAt,
		   LocalDateTime confirmedAt) {
	   return new ConfirmationToken(
			   "confirmationTokenId",
			   performingTransactionBy,
			   "confirmationToken",
			   createdDateTime,
			   expiresAt,
			   confirmedAt
			   );
   }
   
   public ConfirmationToken getMockConfirmationToken() {
	   return Mockito.mock(ConfirmationToken.class);
   }
   
   public RefreshToken getRefreshToken(
		   User performingTransactionBy,
		   LocalDateTime createdDateTime,
		   LocalDateTime expireDateTime) {
	   return new RefreshToken(
			   "refrehTokenId",
			   performingTransactionBy,
			   "refreshToken",
			   expireDateTime,
			   createdDateTime
			   );
   }
   
   public RefreshToken getRefreshToken() {
	   return Mockito.mock(RefreshToken.class);
   }

   
   //------------------------------
   public Territory getTerritory(LocalDateTime createdDateTime, LocalDateTime updatedDateTime)
   {
	   return new Territory(
			   null,
			   "territorName",
			   "territoryDescription",
			   createdDateTime,
			   updatedDateTime
			   );
   }
   
   public TerritoryDto getTerritoryDto(LocalDateTime createdDateTime, LocalDateTime updatedDateTime)
   {
	   return new TerritoryDto(
			   null,
			   "territorName",
			   "territoryDescription",
			   createdDateTime,
			   updatedDateTime
			   );
   }
   
   public City getCity(Territory territory,LocalDateTime createdDateTime, LocalDateTime updatedDateTime)
   {
	   return new City(
			   null,
			   territory,
			   "cityName",
			   "plateCode",
			   "postCode",
			   "phoneNumberCode",
			   "cityDescription",
			   createdDateTime,
			   updatedDateTime
			   );
   }
   
   public CityDto getCityDto(Territory territory,LocalDateTime createdDateTime, LocalDateTime updatedDateTime)
   {
	   return new CityDto(
			   null,
			   territory,
			   "cityName",
			   "plateCode",
			   "postCode",
			   "phoneNumberCode",
			   "cityDescription",
			   createdDateTime,
			   updatedDateTime			   
			   );
   }
   
   public District getDistrict(City city,LocalDateTime createdDateTime, LocalDateTime updatedDateTime)
   {
	   return new District(
			   null,
			   city,
			   "districtName",
			   "postCode",
			   "districtDescription",
			   createdDateTime,
			   updatedDateTime
			   );
   }

   public DistrictDto getDistrictDto(City city,LocalDateTime createdDateTime, LocalDateTime updatedDateTime)
   {
	   return new DistrictDto(
			   null,
			   city,
			   "districtName",
			   "postCode",
			   "districtDescription",
			   createdDateTime,
			   updatedDateTime
			   );
   }
   
   public Town getTown(District district,LocalDateTime createdDateTime, LocalDateTime updatedDateTime)
   {
	   return new Town(
			   null,
			   district,
			   "townName",
			   "townDescription",
			   createdDateTime,
			   updatedDateTime
			   );
   }

   public TownDto getTownDto(District district,LocalDateTime createdDateTime, LocalDateTime updatedDateTime)
   {
	   return new TownDto(
			   null,
			   district,
			   "townName",
			   "townDescription",
			   createdDateTime,
			   updatedDateTime
			   );
   }


   //------------------------------------
   public LogTerritory getLogTerritory(Territory territory, User performingTransactionBy, LocalDateTime createdDateTime)
   {
	   return new LogTerritory(
			   null,
			   CREATED,
			   territory,
			   performingTransactionBy,
			   createdDateTime
			   );
   }
   
   public LogTerritoryDto getLogTerritoryDto(Territory territory, User performingTransactionBy, LocalDateTime createdDateTime)
   {
	   return new LogTerritoryDto(
			   null,
			   CREATED,
			   territory,
			   performingTransactionBy,
			   createdDateTime
			   );
   }
   
   public LogCity getLogCity(City city, User performingTransactionBy, LocalDateTime createdDateTime)
   {
	   return new LogCity(
			   null,
			   CREATED,
			   city,
			   performingTransactionBy,
			   createdDateTime
			   );
   }
   
   public LogCityDto getLogCityDto(City city, User performingTransactionBy, LocalDateTime createdDateTime)
   {
	   return new LogCityDto(
			   null,
			   CREATED,
			   city,
			   performingTransactionBy,
			   createdDateTime
			   );
   }
   
   public LogDistrict getLogDistrict(District district, User performingTransactionBy, LocalDateTime createdDateTime)
   {
	   return new LogDistrict(
			   null,
			   CREATED,
			   district,
			   performingTransactionBy,
			   createdDateTime
			   );
   }

   public LogDistrictDto getLogDistrictDto(District district, User performingTransactionBy, LocalDateTime createdDateTime)
   {
	   return new LogDistrictDto(
			   null,
			   CREATED,
			   district,
			   performingTransactionBy,
			   createdDateTime
			   );
   }
   
   public LogTown getLogTown(Town town, User performingTransactionBy, LocalDateTime createdDateTime)
   {
	   return new LogTown(
			   null,
			   CREATED,
			   town,
			   performingTransactionBy,
			   createdDateTime
			   );
   }

   public LogTownDto getLogTownDto(Town town, User performingTransactionBy, LocalDateTime createdDateTime)
   {
	   return new LogTownDto(
			   null,
			   CREATED,
			   town,
			   performingTransactionBy,
			   createdDateTime
			   );
   }

   public LogUser getLogUser(User user, User performingTransactionBy, LocalDateTime createdDateTime) {
	   
	   return new LogUser(
			   null,
			   CREATED,
			   user,
			   performingTransactionBy,
			   createdDateTime
			   );
	   }
   
   public LogUserDto getLogUserDto(User user, User performingTransactionBy, LocalDateTime createdDateTime)
   {
	   return new LogUserDto(
			   null,
			   CREATED,
			   user,
			   performingTransactionBy,
			   createdDateTime
			   );
   }

   public LogRole getLogRole(Role role, User performingTransactionBy, LocalDateTime createdDateTime)
   {
	   return new LogRole(
			   null,
			   CREATED,
			   role,
			   performingTransactionBy,
			   createdDateTime
			   );
   }
   
   public LogRoleDto getLogRoleDto(Role role, User performingTransactionBy, LocalDateTime createdDateTime)
   {
	    return new LogRoleDto(
	    		   null,
				   CREATED,
				   role,
				   performingTransactionBy,
				   createdDateTime
				   );
   }

   //------------------------------------
	
	
	
	// constructor
	private static BaseMockEntity_DtoAndEntity_DtoModel _baseMockEntity_DtoAndEntity_DtoModel;
    
	public BaseMockEntity_DtoAndEntity_DtoModel() {}

	public static BaseMockEntity_DtoAndEntity_DtoModel getInstance() {
		if(_baseMockEntity_DtoAndEntity_DtoModel==null)
		{
			_baseMockEntity_DtoAndEntity_DtoModel= new BaseMockEntity_DtoAndEntity_DtoModel();
		}
		
		return _baseMockEntity_DtoAndEntity_DtoModel;
	}
}
