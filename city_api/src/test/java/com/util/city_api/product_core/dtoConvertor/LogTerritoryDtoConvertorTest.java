package com.util.city_api.product_core.dtoConvertor;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.util.city_api.entity.log.LogTerritory;
import com.util.city_api.product_core.dto.logDto.LogTerritoryDto;
import com.util.city_api.product_core.dtoConvertor.mockWorkbench.DtoConvertorTestWorkBench;

public class LogTerritoryDtoConvertorTest extends DtoConvertorTestWorkBench{

 	private LogTerritoryDtoConvertor logTerritoryDtoConvertor;
	
	@BeforeEach
	void setup()
	{
		this.logTerritoryDtoConvertor = new LogTerritoryDtoConvertor();
	
	}
 
    @Test
	void WhenLogTerritoryConvertedToLogTerritoryDtoThenReturnLogTerritoryDtoThatAllParametersMustBeSameWithLogTerritoryParamaters() {
    	
    	LogTerritoryDto logTerritoryDtoResult = logTerritoryDtoConvertor.convert(logTerritory);
    	
    	assertEquals(logTerritoryDtoResult.getLogTerritoryId(), logTerritory.getLogTerritoryId());
    	assertEquals(logTerritoryDtoResult.getTransactionType(), logTerritory.getTransactionType());
    	assertEquals(logTerritoryDtoResult.getTerritory(), logTerritory.getTerritory());
    	assertEquals(logTerritoryDtoResult.getPerformingTransactionBy(), logTerritory.getPerformingTransactionBy());
    	assertEquals(logTerritoryDtoResult.getCreatedDate(), logTerritory.getCreatedDate());
    }
	
   @Test
    void WhenLogTerritoryDtoConvertedToLogTerritoryThenReturnLogTerritoryThatAllParametersMustBeSameWithLogTerritoryDtoParamaters() {
   	
   	   LogTerritory logTerritoryResult = logTerritoryDtoConvertor.convert(logTerritoryDto);
   	
   	   assertEquals(logTerritoryResult.getLogTerritoryId(), logTerritoryDto.getLogTerritoryId());
   	   assertEquals(logTerritoryResult.getTransactionType(), logTerritoryDto.getTransactionType());
   	   assertEquals(logTerritoryResult.getTerritory(), logTerritoryDto.getTerritory());
   	   assertEquals(logTerritoryResult.getPerformingTransactionBy(), logTerritoryDto.getPerformingTransactionBy());
   	   assertEquals(logTerritoryResult.getCreatedDate(), logTerritoryDto.getCreatedDate());

   }
}
