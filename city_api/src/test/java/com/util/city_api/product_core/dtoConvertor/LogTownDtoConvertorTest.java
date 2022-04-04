package com.util.city_api.product_core.dtoConvertor;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
		this.logTownDtoConvertor = new LogTownDtoConvertor();
		logTown = super.getLogTown();
		logTownDto = super.getLogTownDto();
	}
 
    @Test
	void WhenLogTownConvertedToLogTownDtoThenReturnLogTownDtoThatAllParametersMustBeSameWithLogTownParamaters() {
    
    	LogTownDto logTownDtoResult = logTownDtoConvertor.convert(logTown);
    	
    	assertEquals(logTownDtoResult.getLogTownId(), logTown.getLogTownId());
    	assertEquals(logTownDtoResult.getTransactionType(), logTown.getTransactionType());
    	assertEquals(logTownDtoResult.getTown(), logTown.getTown());
    	assertEquals(logTownDtoResult.getPerformingTransactionBy(), logTown.getPerformingTransactionBy());
    	assertEquals(logTownDtoResult.getCreatedDate(), logTown.getCreatedDate());
    }
	
	  @Test
    void WhenLogTownDtoConvertedToLogTownThenReturnLogTownThatAllParametersMustBeSameWithLogTownDtoParamaters() {
		    
	    	LogTown logTownResult = logTownDtoConvertor.convert(logTownDto);
	    	
	    	assertEquals(logTownResult.getLogTownId(), logTownDto.getLogTownId());
	    	assertEquals(logTownResult.getTransactionType(), logTownDto.getTransactionType());
	    	assertEquals(logTownResult.getTown(), logTownDto.getTown());
	    	assertEquals(logTownResult.getPerformingTransactionBy(), logTownDto.getPerformingTransactionBy());
	    	assertEquals(logTownResult.getCreatedDate(), logTownDto.getCreatedDate());
	  }
	
}
