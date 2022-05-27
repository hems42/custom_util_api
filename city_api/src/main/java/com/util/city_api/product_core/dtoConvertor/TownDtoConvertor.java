package com.util.city_api.product_core.dtoConvertor;

import org.springframework.stereotype.Component;

import com.util.city_api.entity.primary.Town;
import com.util.city_api.product_core.dto.primaryDto.TownDto;

@Component
public class TownDtoConvertor {

	public Town convert(TownDto from) {
		return new Town(
				from.getTownId(),
				from.getDistrict(),
				from.getTownName(),
				from.getTownDescription(),
				from.getCreatedDate() == null ? null : from.getCreatedDate(),
			    from.getUpdatedDate() == null ? null : from.getUpdatedDate()
				);
	}

	public TownDto convert(Town from) {
		return new TownDto(
				from.getTownId(),
				from.getDistrict(),
				from.getTownName(),
				from.getTownDescription(),
				from.getCreatedDate() == null ? null : from.getCreatedDate(),
			    from.getUpdatedDate() == null ? null : from.getUpdatedDate()
				);
	}

}
