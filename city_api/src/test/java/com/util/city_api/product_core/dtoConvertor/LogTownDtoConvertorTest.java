package com.util.city_api.product_core.dtoConvertor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.util.city_api.baseMockModel.BaseEntityAndDtoTestModel;
import com.util.city_api.entity.log.LogTown;
import com.util.city_api.product_core.dto.logDto.LogTownDto;

public class LogTownDtoConvertorTest extends BaseEntityAndDtoTestModel{

	private LogTownDtoConvertor logTownDtoConvertor;
	private LogTown logTown;
	private LogTownDto logTownDto;
	
	@BeforeEach
	void setup()
	{
		this.logTownDtoConvertor = Mockito.mock(LogTownDtoConvertor.class);
		logTown = super.getLogTown();
		logTownDto = super.getLogTownDto();
	}
 
    @Test
	void WhenLogTownConvertedToLogTownDtoThenReturnLogTownDtoThatAllParametersMustBeSameWithLogTownParamaters() {}
	
	  @Test
    void WhenLogTownDtoConvertedToLogTownThenReturnLogTownThatAllParametersMustBeSameWithLogTownDtoParamaters() {}
	
}
