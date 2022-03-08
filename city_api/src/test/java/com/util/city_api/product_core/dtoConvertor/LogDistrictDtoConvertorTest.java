package com.util.city_api.product_core.dtoConvertor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.util.city_api.baseMockModel.BaseEntityAndDtoTestModel;
import com.util.city_api.entity.log.LogDistrict;
import com.util.city_api.product_core.dto.logDto.LogDistrictDto;

public class LogDistrictDtoConvertorTest extends BaseEntityAndDtoTestModel{
	
 	private LogDistrictDtoConvertor logDistrictDtoConvertor;
	private LogDistrict logDistrict;
	private LogDistrictDto logDistrictDto;
	
	@BeforeEach
	void setup()
	{
		this.logDistrictDtoConvertor = Mockito.mock(LogDistrictDtoConvertor.class);
		logDistrict    = super.getLogDistrict();
		logDistrictDto = super.getLogDistrictDto();
	}
 
    @Test
	void WhenLogDistrictConvertedToLogDistrictDtoThenReturnLogDistrictDtoThatAllParametersMustBeSameWithLogDistrictParamaters() {}
	
	  @Test
    void WhenLogDistrictDtoConvertedToLogDistrictThenReturnLogDistrictThatAllParametersMustBeSameWithLogDistrictDtoParamaters() {}


}
