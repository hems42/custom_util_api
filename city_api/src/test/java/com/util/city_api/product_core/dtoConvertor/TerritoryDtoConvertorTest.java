package com.util.city_api.product_core.dtoConvertor;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.util.city_api.entity.primary.Territory;
import com.util.city_api.product_core.dto.primaryDto.TerritoryDto;
import com.util.city_api.product_core.dtoConvertor.mockWorkbench.DtoConvertorTestWorkBench;

public class TerritoryDtoConvertorTest extends DtoConvertorTestWorkBench{

	private TerritoryDtoConvertor territoryDtoConvertor;	
	
	@BeforeEach
	void setup() {
		this.territoryDtoConvertor = new TerritoryDtoConvertor();
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
