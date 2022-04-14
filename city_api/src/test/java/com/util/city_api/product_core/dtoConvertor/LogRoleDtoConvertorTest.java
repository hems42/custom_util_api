package com.util.city_api.product_core.dtoConvertor;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.util.city_api.entity.log.LogRole;
import com.util.city_api.product_core.dto.logDto.LogRoleDto;
import com.util.city_api.product_core.dtoConvertor.mockWorkbench.DtoConvertorTestWorkBench;

public class LogRoleDtoConvertorTest extends DtoConvertorTestWorkBench{
	
 	private LogRoleDtoConvertor logRoleDtoConvertor;
	
	@BeforeEach
	void setup()
	{
		this.logRoleDtoConvertor = new LogRoleDtoConvertor();
	}
 
    @Test
	void WhenLogRoleConvertedToLogRoleDtoThenReturnLogRoleDtoThatAllParametersMustBeSameWithLogRoleParamaters() {
    	
    	LogRoleDto logRoleDtoResult = logRoleDtoConvertor.convert(logRole);
    	
    	assertEquals(logRoleDtoResult.getLogRoleId(), logRole.getLogRoleId());
    	assertEquals(logRoleDtoResult.getTransactionType(), logRole.getTransactionType());
    	assertEquals(logRoleDtoResult.getRole(), logRole.getRole());
    	assertEquals(logRoleDtoResult.getPerformingTransactionBy(), logRole.getPerformingTransactionBy());
    	assertEquals(logRoleDtoResult.getCreatedDate(), logRole.getCreatedDate());
    }
	
	  @Test
    void WhenLogRoleDtoConvertedToLogRoleThenReturnLogRoleThatAllParametersMustBeSameWithLogRoleDtoParamaters() {
	    	
	      LogRole logRoleResult = logRoleDtoConvertor.convert(logRoleDto);
	    	
	      assertEquals(logRoleResult.getLogRoleId(), logRoleDto.getLogRoleId());
	      assertEquals(logRoleResult.getTransactionType(), logRoleDto.getTransactionType());
	      assertEquals(logRoleResult.getRole(), logRoleDto.getRole());
	      assertEquals(logRoleResult.getPerformingTransactionBy(), logRoleDto.getPerformingTransactionBy());
	      assertEquals(logRoleResult.getCreatedDate(), logRoleDto.getCreatedDate());
	  }

}
