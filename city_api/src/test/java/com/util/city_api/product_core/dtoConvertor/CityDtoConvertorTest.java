package com.util.city_api.product_core.dtoConvertor;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.util.city_api.entity._core.City;
import com.util.city_api.product_core.dto._coreDto.CityDto;
import com.util.city_api.product_core.dtoConvertor.mockWorkbench.DtoConvertorTestWorkBench;

public class CityDtoConvertorTest extends DtoConvertorTestWorkBench{

	private CityDtoConvertor cityDtoConvertor;
	
	@BeforeEach
	void setup()
	{
		this.cityDtoConvertor = new CityDtoConvertor();
	
	}
	
	@Test
	void WhenCityConvertedToCityDtoThenReturnCityDtoThatAllParametersMustBeSameWithCityParamaters() {

    	CityDto cityDtoResult = cityDtoConvertor.convert(city);

    	assertEquals(cityDtoResult.getCityId(), city.getCityId());
    	assertEquals(cityDtoResult.getTerritory(), city.getTerritory());
    	assertEquals(cityDtoResult.getCityName(), city.getCityName());
    	assertEquals(cityDtoResult.getPlateCode(), city.getPlateCode());
    	assertEquals(cityDtoResult.getPostCode(), city.getPostCode());
    	assertEquals(cityDtoResult.getPhoneNumberCode(), city.getPhoneNumberCode());
    	assertEquals(cityDtoResult.getCityDescription(), city.getCityDescription());
    	assertEquals(cityDtoResult.getCreatedDate(), city.getCreatedDate());
    	assertEquals(cityDtoResult.getUpdatedDate(), city.getUpdatedDate());
	}
	
	@Test
    void WhenCityDtoConvertedToCityThenReturnCityThatAllParametersMustBeSameWithCityDtoParamaters() {

    	City cityResult = cityDtoConvertor.convert(cityDto);

    	assertEquals(cityResult.getCityId(), cityDto.getCityId());
    	assertEquals(cityResult.getTerritory(), cityDto.getTerritory());
    	assertEquals(cityResult.getCityName(), cityDto.getCityName());
    	assertEquals(cityResult.getPlateCode(), cityDto.getPlateCode());
    	assertEquals(cityResult.getPostCode(), cityDto.getPostCode());
    	assertEquals(cityResult.getPhoneNumberCode(), cityDto.getPhoneNumberCode());
    	assertEquals(cityResult.getCityDescription(), cityDto.getCityDescription());
    	assertEquals(cityResult.getCreatedDate(), cityDto.getCreatedDate());
    	assertEquals(cityResult.getUpdatedDate(), cityDto.getUpdatedDate());		
	}
}
