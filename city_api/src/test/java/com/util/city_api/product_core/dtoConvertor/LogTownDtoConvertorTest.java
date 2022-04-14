package com.util.city_api.product_core.dtoConvertor;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.util.city_api.entity.log.LogTown;
import com.util.city_api.product_core.dto.logDto.LogTownDto;
import com.util.city_api.product_core.dtoConvertor.mockWorkbench.DtoConvertorTestWorkBench;

public class LogTownDtoConvertorTest extends DtoConvertorTestWorkBench{

	private LogTownDtoConvertor logTownDtoConvertor;
	
	@BeforeEach
	void setup()
	{
		this.logTownDtoConvertor = new LogTownDtoConvertor();
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
