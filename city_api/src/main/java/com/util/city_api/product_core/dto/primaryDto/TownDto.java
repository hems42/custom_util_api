package com.util.city_api.product_core.dto.primaryDto;

import java.time.LocalDateTime;

import com.util.city_api.entity.primary.District;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TownDto {

    private String townId;

    private District district;

    private String townName;

    private String townDescription;

    private LocalDateTime createdDate;

    private LocalDateTime updatedDate;

}
