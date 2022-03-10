package com.util.city_api.product_core.dtoConvertor;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
	void WhenLogRoleConvertedToLogRoleDtoThenReturnLogRoleDtoThatAllParametersMustBeSameWithLogRoleParamaters() {
    	
    	Mockito.when(logRoleDtoConvertor.convert(logRole)).thenReturn(logRoleDto);
    	
    	LogRoleDto logRoleDtoResult = logRoleDtoConvertor.convert(logRole);
    	
    	assertEquals(logRoleDtoResult.getLogRoleId(), logRole.getLogRoleId());
    	assertEquals(logRoleDtoResult.getTransactionType(), logRole.getTransactionType());
    	assertEquals(logRoleDtoResult.getRole(), logRole.getRole());
    	assertEquals(logRoleDtoResult.getPerformingTransactionBy(), logRole.getPerformingTransactionBy());
    	assertEquals(logRoleDtoResult.getCreatedDate(), logRole.getCreatedDate());
    }
	
	  @Test
    void WhenLogRoleDtoConvertedToLogRoleThenReturnLogRoleThatAllParametersMustBeSameWithLogRoleDtoParamaters() {
		  
		  Mockito.when(logRoleDtoConvertor.convert(logRoleDto)).thenReturn(logRole);
	    	
	      LogRole logRoleResult = logRoleDtoConvertor.convert(logRoleDto);
	    	
	      assertEquals(logRoleResult.getLogRoleId(), logRoleDto.getLogRoleId());
	      assertEquals(logRoleResult.getTransactionType(), logRoleDto.getTransactionType());
	      assertEquals(logRoleResult.getRole(), logRoleDto.getRole());
	      assertEquals(logRoleResult.getPerformingTransactionBy(), logRoleDto.getPerformingTransactionBy());
	      assertEquals(logRoleResult.getCreatedDate(), logRoleDto.getCreatedDate());
	  }

}
