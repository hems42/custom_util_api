package com.util.city_api.product_core.dtoConvertor;

import org.springframework.stereotype.Component;

import com.util.city_api.entity._core.Territory;
import com.util.city_api.product_core.dto._coreDto.TerritoryDto;

@Component
public class TerritoryDtoConvertor {

	public Territory convert(TerritoryDto from) {
		return new Territory(
				from.getTerritoryId(),
				from.getTerritoryName(),
				from.getTerritoryDescription(),
		        from.getCreatedDate() == null ? null : from.getCreatedDate(),
		        from.getUpdatedDate() == null ? null : from.getUpdatedDate()
		        );
	}

	public TerritoryDto convert(Territory from) {
		return new TerritoryDto(
				from.getTerritoryId(),
				from.getTerritoryName(),
				from.getTerritoryDescription(),
		        from.getCreatedDate() == null ? null : from.getCreatedDate(),
		        from.getUpdatedDate() == null ? null : from.getUpdatedDate()		      
				);
	}

}
