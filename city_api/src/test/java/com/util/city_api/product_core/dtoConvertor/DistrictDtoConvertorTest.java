package com.util.city_api.product_core.dtoConvertor;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.util.city_api.entity.primary.District;
import com.util.city_api.product_core.dto.primaryDto.DistrictDto;
import com.util.city_api.product_core.dtoConvertor.mockWorkbench.DtoConvertorTestWorkBench;

public class DistrictDtoConvertorTest extends DtoConvertorTestWorkBench{

	private DistrictDtoConvertor districtDtoConvertor;
	
	@BeforeEach
	void setup()
	{
		this.districtDtoConvertor = new DistrictDtoConvertor();
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




