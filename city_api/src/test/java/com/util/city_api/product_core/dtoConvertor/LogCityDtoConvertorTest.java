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
		this.logCityDtoConvertor = Mockito.mock(LogCityDtoConvertor.class);
		logCity = super.getLogCity();
		logCityDto = super.getLogCityDto();
	}
	
    @Test
    void WhenLogCityConvertedToLogCityDtoThenReturnLogCityDtoThatAllParametersMustBeSameWithLogCityParamaters() {
    	
    	Mockito.when(logCityDtoConvertor.convert(logCity)).thenReturn(logCityDto);
    	
    	LogCityDto logCityDtoResult = logCityDtoConvertor.convert(logCity);
    	
    }
    	
    	//assertEquals(logCityDtoResult.getDistrictId(), district.getDistrictId());    }
    
    @Test
    void WhenLogCityDtoConvertedToLogCityThenReturnLogCityThatAllParametersMustBeSameWithLogCityDtoParamaters() {
    	
        Mockito.when(logCityDtoConvertor.convert(logCityDto)).thenReturn(logCity);
    	
    	LogCity logCityResult = logCityDtoConvertor.convert(logCityDto);
    	
    	//assertEquals(logCityResult.getDistrictId(), districtDto.getDistrictId());
    
   
    }
}
