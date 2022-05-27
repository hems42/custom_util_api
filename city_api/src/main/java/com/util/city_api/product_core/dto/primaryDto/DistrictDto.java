package com.util.city_api.product_core.dto.primaryDto;

import java.time.LocalDateTime;

import com.util.city_api.entity.primary.City;

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
