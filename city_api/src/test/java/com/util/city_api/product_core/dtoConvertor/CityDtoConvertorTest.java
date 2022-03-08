package com.util.city_api.product_core.dtoConvertor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.util.city_api.baseMockModel.BaseEntityAndDtoTestModel;
import com.util.city_api.entity._core.City;
import com.util.city_api.product_core.dto._coreDto.CityDto;

public class CityDtoConvertorTest extends BaseEntityAndDtoTestModel{

	private CityDtoConvertor cityDtoConvertor;
	private City city;
	private CityDto cityDto;
	
	@BeforeEach
	void setup()
	{
		this.cityDtoConvertor = Mockito.mock(CityDtoConvertor.class);
		city = super.getCity();
		cityDto = super.getCityDto();
	}
	
	@Test
	void WhenCityConvertedToCityDtoThenReturnCityDtoThatAllParametersMustBeSameWithCityParamaters() {}
	
	@Test
    void WhenCityDtoConvertedToCityThenReturnCityThatAllParametersMustBeSameWithCityDtoParamaters() {}
}
