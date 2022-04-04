package com.util.city_api.product_core.dtoConvertor;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.util.city_api.baseMockModel.BaseEntityAndDtoTestModel;
import com.util.city_api.entity.log.LogCity;
import com.util.city_api.product_core.dto.logDto.LogCityDto;

public class LogCityDtoConvertorTest extends BaseEntityAndDtoTestModel{

	private LogCityDtoConvertor logCityDtoConvertor;
	private LogCity logCity;
	private LogCityDto logCityDto;
	
	@BeforeEach
	void setup()
	{
		this.logCityDtoConvertor = new LogCityDtoConvertor();
		logCity = super.getLogCity();
		logCityDto = super.getLogCityDto();
	}
	
    @Test
    void WhenLogCityConvertedToLogCityDtoThenReturnLogCityDtoThatAllParametersMustBeSameWithLogCityParamaters() {
    	
    	LogCityDto logCityDtoResult = logCityDtoConvertor.convert(logCity);
    	
    	assertEquals(logCityDtoResult.getLogCityId(), logCity.getLogCityId());
    	assertEquals(logCityDtoResult.getTransactionType(), logCity.getTransactionType());
    	assertEquals(logCityDtoResult.getCity(), logCity.getCity());
    	assertEquals(logCityDtoResult.getPerformingTransactionBy(), logCity.getPerformingTransactionBy());
    	assertEquals(logCityDtoResult.getCreatedDate(), logCity.getCreatedDate());

    }   	
    
    @Test
    void WhenLogCityDtoConvertedToLogCityThenReturnLogCityThatAllParametersMustBeSameWithLogCityDtoParamaters() {
    	
    	LogCity logCityResult = logCityDtoConvertor.convert(logCityDto);
    	
    	assertEquals(logCityResult.getLogCityId(), logCityDto.getLogCityId());
    	assertEquals(logCityResult.getTransactionType(), logCityDto.getTransactionType());
    	assertEquals(logCityResult.getCity(), logCityDto.getCity());
    	assertEquals(logCityResult.getPerformingTransactionBy(), logCityDto.getPerformingTransactionBy());
    	assertEquals(logCityResult.getCreatedDate(), logCityDto.getCreatedDate());
    }
}
