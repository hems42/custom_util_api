package com.util.city_api.product_core.dtoConvertor;

import org.springframework.stereotype.Component;

import com.util.city_api.entity.primary.District;
import com.util.city_api.product_core.dto.primaryDto.DistrictDto;

@Component
public class DistrictDtoConvertor  {

	public District convert(DistrictDto from) {
		return new District(
				from.getDistrictId(),
				from.getCity(),
				from.getDistrictName(),
				from.getPostCode(),
				from.getDistrictDescription(),
                from.getCreatedDate() == null ? null : from.getCreatedDate(),
                from.getUpdatedDate() == null ? null : from.getUpdatedDate()
				);
	}

	public DistrictDto convert(District from) {
		return new DistrictDto(
				from.getDistrictId(),
				from.getCity(),
				from.getDistrictName(),
				from.getPostCode(),
				from.getDistrictDescription(),
                from.getCreatedDate() == null ? null : from.getCreatedDate(),
                from.getUpdatedDate() == null ? null : from.getUpdatedDate()
				
				);
	}

}
