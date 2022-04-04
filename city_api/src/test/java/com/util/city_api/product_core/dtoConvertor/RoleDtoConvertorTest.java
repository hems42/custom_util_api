package com.util.city_api.product_core.dtoConvertor;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.util.city_api.baseMockModel.BaseEntityAndDtoTestModel;
import com.util.city_api.entity._core.Role;
import com.util.city_api.product_core.dto._coreDto.RoleDto;

public class RoleDtoConvertorTest extends BaseEntityAndDtoTestModel{
	
	private RoleDtoConvertor roleDtoConvertor;
	private Role role;
	private RoleDto roleDto;
	
	@BeforeEach
	void setup()
	{
		this.roleDtoConvertor = new RoleDtoConvertor();
		role = super.getRole();
		roleDto = super.getRoleDto();
	}
 
    @Test
	void WhenRoleConvertedToRoleDtoThenReturnRoleDtoThatAllParametersMustBeSameWithRoleParamaters() {
    	
    	RoleDto roleDtoResult = roleDtoConvertor.convert(role);
    	
    	assertEquals(roleDtoResult.getRoleId(), role.getRoleId());
    	assertEquals(roleDtoResult.getRoleName(), role.getRoleName());
    	assertEquals(roleDtoResult.getRoleDescription(), role.getRoleDescription());
    	assertEquals(roleDtoResult.getCreatedDate(), role.getCreatedDate());
    	assertEquals(roleDtoResult.getUpdatedDate(), role.getUpdatedDate());
    }
	
	  @Test
    void WhenRoleDtoConvertedToRoleThenReturnRoleThatAllParametersMustBeSameWithRoleDtoParamaters() {
	    	
	    	Role roleResult = roleDtoConvertor.convert(roleDto);
	    	
	    	assertEquals(roleResult.getRoleId(), roleDto.getRoleId());
	    	assertEquals(roleResult.getRoleName(), roleDto.getRoleName());
	    	assertEquals(roleResult.getRoleDescription(), roleDto.getRoleDescription());
	    	assertEquals(roleResult.getCreatedDate(), roleDto.getCreatedDate());
	    	assertEquals(roleResult.getUpdatedDate(), roleDto.getUpdatedDate());		  
	  }
 
}
