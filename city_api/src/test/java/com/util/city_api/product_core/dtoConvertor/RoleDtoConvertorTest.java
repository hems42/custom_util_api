package com.util.city_api.product_core.dtoConvertor;

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
		this.roleDtoConvertor = Mockito.mock(RoleDtoConvertor.class);
		role = super.getRole();
		roleDto = super.getRoleDto();
	}
 
    @Test
	void WhenRoleConvertedToRoleDtoThenReturnRoleDtoThatAllParametersMustBeSameWithRoleParamaters() {}
	
	  @Test
    void WhenRoleDtoConvertedToRoleThenReturnRoleThatAllParametersMustBeSameWithRoleDtoParamaters() {}
 
}
