package com.util.city_api.product_core.dtoConvertor.mockWorkbench;

import java.time.LocalDateTime;
import java.util.HashSet;

import com.util.city_api.baseMockModel.BaseMockEntity_DtoAndEntity_DtoModel;
import com.util.city_api.baseMockModel.BaseTestWorkBench;
import com.util.city_api.baseMockModel.BaseUtilityModel;
import com.util.city_api.entity.log.LogCity;
import com.util.city_api.entity.log.LogDistrict;
import com.util.city_api.entity.log.LogRole;
import com.util.city_api.entity.log.LogTerritory;
import com.util.city_api.entity.log.LogTown;
import com.util.city_api.entity.log.LogUser;
import com.util.city_api.entity.primary.City;
import com.util.city_api.entity.primary.District;
import com.util.city_api.entity.primary.Role;
import com.util.city_api.entity.primary.Territory;
import com.util.city_api.entity.primary.Town;
import com.util.city_api.entity.primary.User;
import com.util.city_api.product_core.dto.logDto.LogCityDto;
import com.util.city_api.product_core.dto.logDto.LogDistrictDto;
import com.util.city_api.product_core.dto.logDto.LogRoleDto;
import com.util.city_api.product_core.dto.logDto.LogTerritoryDto;
import com.util.city_api.product_core.dto.logDto.LogTownDto;
import com.util.city_api.product_core.dto.logDto.LogUserDto;
import com.util.city_api.product_core.dto.primaryDto.CityDto;
import com.util.city_api.product_core.dto.primaryDto.DistrictDto;
import com.util.city_api.product_core.dto.primaryDto.RoleDto;
import com.util.city_api.product_core.dto.primaryDto.TerritoryDto;
import com.util.city_api.product_core.dto.primaryDto.TownDto;
import com.util.city_api.product_core.dto.primaryDto.UserDto;

public class DtoConvertorTestWorkBench extends BaseTestWorkBench {

	private BaseMockEntity_DtoAndEntity_DtoModel entityModel =getEntityDtoModels();
	private BaseUtilityModel utilModel = getUtilityModels();
	
	private LocalDateTime localDateTime = utilModel.getTime();
	private HashSet<Role> roles = new HashSet<Role>();
	
	
	public Territory territory = entityModel.getTerritory(localDateTime, localDateTime);
	public TerritoryDto territoryDto = entityModel.getTerritoryDto(localDateTime, localDateTime);
	
	public City city = entityModel.getCity(territory, localDateTime, localDateTime);
	public CityDto cityDto = entityModel.getCityDto(territory, localDateTime, localDateTime);
	
	public District district = entityModel.getDistrict(city, localDateTime, localDateTime);
	public DistrictDto districtDto = entityModel.getDistrictDto(city, localDateTime, localDateTime);
	
	public Town town = entityModel.getTown(district, localDateTime, localDateTime);
	public TownDto townDto = entityModel.getTownDto(district, localDateTime, localDateTime);
	
	public User user =  entityModel.getUser(roles, localDateTime, localDateTime);
	public UserDto userDto = entityModel.getUserDto(roles, localDateTime, localDateTime);
	
	public Role role = entityModel.getRole(localDateTime, localDateTime);
	public RoleDto roleDto = entityModel.getRoleDto(localDateTime, localDateTime);
	
	public LogTerritory logTerritory = entityModel.getLogTerritory(territory, user, localDateTime);
	public LogTerritoryDto logTerritoryDto = entityModel.getLogTerritoryDto(territory, user, localDateTime);
	
	public LogCity logCity = entityModel.getLogCity(city, user, localDateTime);
	public LogCityDto logCityDto = entityModel.getLogCityDto(city, user, localDateTime);
	
	public LogDistrict logDistrict = entityModel.getLogDistrict(district, user, localDateTime);
	public LogDistrictDto logDistrictDto = entityModel.getLogDistrictDto(district, user, localDateTime);
	
	public LogTown logTown = entityModel.getLogTown(town, user, localDateTime);
	public LogTownDto logTownDto = entityModel.getLogTownDto(town, user, localDateTime);
	
	public LogUser logUser = entityModel.getLogUser(user, user, localDateTime);
	public LogUserDto logUserDto = entityModel.getLogUserDto(user, user, localDateTime);
	
	public LogRole logRole = entityModel.getLogRole(role, user, localDateTime);
	public LogRoleDto logRoleDto = entityModel.getLogRoleDto(role, user, localDateTime);
}
