package com.util.city_api.product_core.dtoConvertor;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.util.city_api.baseMock.BaseEntityAndDtoTestModel;
import com.util.city_api.entity._core.Territory;
import com.util.city_api.product_core.dto._coreDto.TerritoryDto;

public class TerritoryDtoConvertorTest extends BaseEntityAndDtoTestModel{

	private TerritoryDtoConvertor territoryDtoConvertor;	
	private Territory territory;	
	private TerritoryDto territoryDto;
	
	@BeforeEach
	void setup() {
		this.territoryDtoConvertor = new TerritoryDtoConvertor();
		territory = super.getTerritory();
		territoryDto = super.getTerritoryDto();
	}
	
	@Test
	void WhenTerritoryConvertedToTerritoryDtoThenReturnTerritoryDtoThatAllParametersMustBeSameWithTerritoryParamaters() {
		
		TerritoryDto territoryDtoResult = territoryDtoConvertor.convert(territory);
	
		assertEquals(territoryDtoResult.getTerritoryId(), territory.getTerritoryId());
		assertEquals(territoryDtoResult.getTerritoryName(), territory.getTerritoryName());
		assertEquals(territoryDtoResult.getTerritoryDescription(), territory.getTerritoryDescription());
		assertEquals(territoryDtoResult.getCreatedDate(), territory.getCreatedDate());
		assertEquals(territoryDtoResult.getUpdatedDate(), territory.getUpdatedDate());
	}
		
	@Test
	void WhenTerritoryDtoConvertedToTerritoryThenReturnTerritoryThatAllParametersMustBeSameWithTerritoryDtoParamaters() {
		
		Territory territoryResult = territoryDtoConvertor.convert(territoryDto);
	
		assertEquals(territoryResult.getTerritoryId(), territoryDto.getTerritoryId());
		assertEquals(territoryResult.getTerritoryName(), territoryDto.getTerritoryName());
		assertEquals(territoryResult.getTerritoryDescription(), territoryDto.getTerritoryDescription());
		assertEquals(territoryResult.getCreatedDate(), territoryDto.getCreatedDate());
		assertEquals(territoryResult.getUpdatedDate(), territoryDto.getUpdatedDate());
	}
	 
}
