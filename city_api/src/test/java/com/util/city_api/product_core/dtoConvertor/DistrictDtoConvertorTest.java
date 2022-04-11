package com.util.city_api.product_core.dtoConvertor;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.util.city_api.baseMock.BaseEntityAndDtoTestModel;
import com.util.city_api.entity._core.District;
import com.util.city_api.product_core.dto._coreDto.DistrictDto;

public class DistrictDtoConvertorTest extends BaseEntityAndDtoTestModel{

	private DistrictDtoConvertor districtDtoConvertor;
	private District district;
	private DistrictDto districtDto;
	
	@BeforeEach
	void setup()
	{
		this.districtDtoConvertor = new DistrictDtoConvertor();
		district = super.getDistrict();
		districtDto = super.getDistrictDto();
	}
	
    @Test
    void WhenDistrictConvertedToDistrictDtoThenReturnDistrictDtoThatAllParametersMustBeSameWithDistrictParamaters() {
    	
    	DistrictDto districtDtoResult = districtDtoConvertor.convert(district);
    	
    	assertEquals(districtDtoResult.getDistrictId(), district.getDistrictId());
    	assertEquals(districtDtoResult.getCity(), district.getCity());
    	assertEquals(districtDtoResult.getDistrictName(), district.getDistrictName());
    	assertEquals(districtDtoResult.getPostCode(), district.getPostCode());
    	assertEquals(districtDtoResult.getDistrictDescription(), district.getDistrictDescription());
    	assertEquals(districtDtoResult.getCreatedDate(), district.getCreatedDate());
    	assertEquals(districtDtoResult.getUpdatedDate(), district.getUpdatedDate());    	        
    }
    
    @Test
    void WhenDistrictDtoConvertedToDistrictThenReturnDistrictThatAllParametersMustBeSameWithDistrictDtoParamaters() {
    	
    	District districtResult = districtDtoConvertor.convert(districtDto);
    	
    	assertEquals(districtResult.getDistrictId(), districtDto.getDistrictId());
    	assertEquals(districtResult.getCity(), districtDto.getCity());
    	assertEquals(districtResult.getDistrictName(), districtDto.getDistrictName());
    	assertEquals(districtResult.getPostCode(), districtDto.getPostCode());
    	assertEquals(districtResult.getDistrictDescription(), districtDto.getDistrictDescription());
    	assertEquals(districtResult.getCreatedDate(), districtDto.getCreatedDate());
    	assertEquals(districtResult.getUpdatedDate(), districtDto.getUpdatedDate()); 
    }
}




