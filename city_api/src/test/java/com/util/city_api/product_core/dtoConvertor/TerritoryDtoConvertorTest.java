package com.util.city_api.product_core.dtoConvertor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.util.city_api.baseMockModel.BaseEntityAndDtoTestModel;
import com.util.city_api.entity._core.Territory;
import com.util.city_api.product_core.dto._coreDto.TerritoryDto;

public class TerritoryDtoConvertorTest extends BaseEntityAndDtoTestModel{

	private TerritoryDtoConvertor territoryDtoConvertor;	
	private Territory territory;	
	private TerritoryDto territoryDto;
	
	@BeforeEach
	void setup() {
		this.territoryDtoConvertor = Mockito.mock(TerritoryDtoConvertor.class);
		territory = super.getTerritory();
		territoryDto = super.getTerritoryDto();
	}
	
	  @Test
		void WhenTerritoryConvertedToTerritoryDtoThenReturnTerritoryDtoThatAllParametersMustBeSameWithTerritoryParamaters() {}
		
		 @Test
		void WhenTerritoryDtoConvertedToTerritoryThenReturnTerritoryThatAllParametersMustBeSameWithTerritoryDtoParamaters() {}
	 
}
