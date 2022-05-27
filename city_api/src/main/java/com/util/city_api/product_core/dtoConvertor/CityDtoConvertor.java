package com.util.city_api.product_core.dtoConvertor;

import org.springframework.stereotype.Component;

import com.util.city_api.entity.primary.City;
import com.util.city_api.product_core.dto.primaryDto.CityDto;

import lombok.extern.slf4j.Slf4j;

@Component
public class CityDtoConvertor  {
	
	private final String logTitle="CityDtoConvertor: ->";

	public City convert(CityDto from) {
		return new City(
				from.getCityId(),
				from.getTerritory(),
				from.getCityName(),
				from.getPlateCode(),
				from.getPostCode(),
				from.getPhoneNumberCode(),
				from.getCityDescription(),
                from.getCreatedDate() == null ? null : from.getCreatedDate(),
                from.getUpdatedDate() == null ? null : from.getUpdatedDate());
	}

	public CityDto convert(City from) {
		return new CityDto(
				from.getCityId(),
				from.getTerritory(),
				from.getCityName(),
				from.getPlateCode(),
				from.getPostCode(),
				from.getPhoneNumberCode(),
				from.getCityDescription(),
                from.getCreatedDate() == null ? null : from.getCreatedDate(),
                from.getUpdatedDate() == null ? null : from.getUpdatedDate()
				);
	}

}
