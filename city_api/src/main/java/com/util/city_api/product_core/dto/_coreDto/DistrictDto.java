package com.util.city_api.product_core.dto._coreDto;

import java.time.LocalDateTime;

import com.util.city_api.entity._core.City;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DistrictDto {

    private String districtId;
    
    private City city;

    private String districtName;

    private String postCode;

    private String districtDescription;

    private LocalDateTime createdDate;

    private LocalDateTime updatedDate;

}
