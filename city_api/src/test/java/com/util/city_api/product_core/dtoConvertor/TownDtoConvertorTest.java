package com.util.city_api.product_core.dtoConvertor;

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
		this.townDtoConvertor = Mockito.mock(TownDtoConvertor.class);
		town = super.getTown();
		townDto = super.getTownDto();
	}
 
    @Test
	void WhenTownConvertedToTownDtoThenReturnTownDtoThatAllParametersMustBeSameWithTownParamaters() {}
	
	 @Test
	void WhenTownDtoConvertedToTownThenReturnTownThatAllParametersMustBeSameWithTownDtoParamaters() {}
 

}
