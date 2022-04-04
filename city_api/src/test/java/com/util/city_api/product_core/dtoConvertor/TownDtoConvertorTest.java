package com.util.city_api.product_core.dtoConvertor;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.util.city_api.baseMockModel.BaseEntityAndDtoTestModel;
import com.util.city_api.entity._core.Town;
import com.util.city_api.product_core.dto._coreDto.TownDto;

public class TownDtoConvertorTest extends BaseEntityAndDtoTestModel{
	
 	private TownDtoConvertor townDtoConvertor;
	private Town town;
	private TownDto townDto;
	
	@BeforeEach
	void setup()
	{
		this.townDtoConvertor = new TownDtoConvertor();
		town = super.getTown();
		townDto = super.getTownDto();
	}
 
    @Test
	void WhenTownConvertedToTownDtoThenReturnTownDtoThatAllParametersMustBeSameWithTownParamaters() {
    	
    	TownDto townDtoResult = townDtoConvertor.convert(town);
    	
    	assertEquals(townDtoResult.getTownId(), town.getTownId());
    	assertEquals(townDtoResult.getDistrict(), town.getDistrict());
    	assertEquals(townDtoResult.getTownName(), town.getTownName());
    	assertEquals(townDtoResult.getTownDescription(), town.getTownDescription());
    	assertEquals(townDtoResult.getCreatedDate(), town.getCreatedDate());
    	assertEquals(townDtoResult.getUpdatedDate(), town.getUpdatedDate());
    }
	
	 @Test
	void WhenTownDtoConvertedToTownThenReturnTownThatAllParametersMustBeSameWithTownDtoParamaters() {
	    	
	    	Town townResult = townDtoConvertor.convert(townDto);
	    	
	    	assertEquals(townResult.getTownId(), townDto.getTownId());
	    	assertEquals(townResult.getDistrict(), townDto.getDistrict());
	    	assertEquals(townResult.getTownName(), townDto.getTownName());
	    	assertEquals(townResult.getTownDescription(), townDto.getTownDescription());
	    	assertEquals(townResult.getCreatedDate(), townDto.getCreatedDate());
	    	assertEquals(townResult.getUpdatedDate(), townDto.getUpdatedDate());
	 }
 
}
