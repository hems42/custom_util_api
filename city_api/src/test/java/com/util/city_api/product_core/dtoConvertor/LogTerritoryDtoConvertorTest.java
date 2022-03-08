package com.util.city_api.product_core.dtoConvertor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.util.city_api.baseMockModel.BaseEntityAndDtoTestModel;
import com.util.city_api.entity.log.LogTerritory;
import com.util.city_api.product_core.dto.logDto.LogTerritoryDto;

public class LogTerritoryDtoConvertorTest extends BaseEntityAndDtoTestModel{

 	private LogTerritoryDtoConvertor logTerritoryDtoConvertor;
	private LogTerritory logTerritory;
	private LogTerritoryDto logTerritoryDto;
	
	@BeforeEach
	void setup()
	{
		this.logTerritoryDtoConvertor = Mockito.mock(LogTerritoryDtoConvertor.class);
		logTerritory = super.getLogTerritory();
		logTerritoryDto = super.getLogTerritoryDto();
	}
 
    @Test
	void WhenLogTerritoryConvertedToLogTerritoryDtoThenReturnLogTerritoryDtoThatAllParametersMustBeSameWithLogTerritoryParamaters() {}
	
   @Test
    void WhenLogTerritoryDtoConvertedToLogTerritoryThenReturnLogTerritoryThatAllParametersMustBeSameWithLogTerritoryDtoParamaters() {}
}
