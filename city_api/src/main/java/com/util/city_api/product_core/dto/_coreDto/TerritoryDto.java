package com.util.city_api.product_core.dto._coreDto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TerritoryDto {

    private String territoryId;

	private String territoryName;

    private String territoryDescription;

    private LocalDateTime createdDate;

    private LocalDateTime updatedDate; 
    
}


