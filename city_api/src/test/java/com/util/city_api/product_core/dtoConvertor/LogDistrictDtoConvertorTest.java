package com.util.city_api.product_core.dtoConvertor;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
		this.logDistrictDtoConvertor = new LogDistrictDtoConvertor();
		logDistrict    = super.getLogDistrict();
		logDistrictDto = super.getLogDistrictDto();
	}
 
    @Test
	void WhenLogDistrictConvertedToLogDistrictDtoThenReturnLogDistrictDtoThatAllParametersMustBeSameWithLogDistrictParamaters() {
    	
    	LogDistrictDto logDistrictDtoResult = logDistrictDtoConvertor.convert(logDistrict);
    	
    	assertEquals(logDistrictDtoResult.getLogDistrictId(), logDistrict.getLogDistrictId());
    	assertEquals(logDistrictDtoResult.getTransactionType(), logDistrict.getTransactionType());
    	assertEquals(logDistrictDtoResult.getDistrict(), logDistrict.getDistrict());
    	assertEquals(logDistrictDtoResult.getPerformingTransactionBy(), logDistrict.getPerformingTransactionBy());
    	assertEquals(logDistrictDtoResult.getCreatedDate(), logDistrict.getCreatedDate());
    	
    }
	
	  @Test
    void WhenLogDistrictDtoConvertedToLogDistrictThenReturnLogDistrictThatAllParametersMustBeSameWithLogDistrictDtoParamaters() {
	    	
	    	LogDistrict logDistrictResult = logDistrictDtoConvertor.convert(logDistrictDto);
	    	
	    	assertEquals(logDistrictResult.getLogDistrictId(), logDistrictDto.getLogDistrictId());
	    	assertEquals(logDistrictResult.getTransactionType(), logDistrictDto.getTransactionType());
	    	assertEquals(logDistrictResult.getDistrict(), logDistrictDto.getDistrict());
	    	assertEquals(logDistrictResult.getPerformingTransactionBy(), logDistrictDto.getPerformingTransactionBy());
	    	assertEquals(logDistrictResult.getCreatedDate(), logDistrictDto.getCreatedDate());
		  
	  }

	  

}
