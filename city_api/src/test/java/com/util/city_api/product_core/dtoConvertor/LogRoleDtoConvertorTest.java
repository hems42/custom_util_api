package com.util.city_api.product_core.dtoConvertor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.util.city_api.baseMockModel.BaseEntityAndDtoTestModel;
import com.util.city_api.entity.log.LogRole;
import com.util.city_api.product_core.dto.logDto.LogRoleDto;

public class LogRoleDtoConvertorTest extends BaseEntityAndDtoTestModel{
	
 	private LogRoleDtoConvertor logRoleDtoConvertor;
	private LogRole logRole;
	private LogRoleDto logRoleDto;
	
	@BeforeEach
	void setup()
	{
		this.logRoleDtoConvertor = Mockito.mock(LogRoleDtoConvertor.class);
		logRole = super.getLogRole();
		logRoleDto = super.getLogRoleDto();
	}
 
    @Test
	void WhenLogRoleConvertedToLogRoleDtoThenReturnLogRoleDtoThatAllParametersMustBeSameWithLogRoleParamaters() {}
	
	  @Test
    void WhenLogRoleDtoConvertedToLogRoleThenReturnLogRoleThatAllParametersMustBeSameWithLogRoleDtoParamaters() {}

}
