package com.util.city_api.product_core.dto._coreDto;

import java.time.LocalDateTime;

import com.util.city_api.entity._core.Territory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CityDto {

    private String cityId;

	private Territory territory;

    private String cityName;

    private String plateCode;

    private String postCode;

    private String phoneNumberCode;

    private String cityDescription;

    private LocalDateTime createdDate;

    private LocalDateTime updatedDate;

}
