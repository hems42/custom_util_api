package com.util.city_api.product_core.dto._coreDto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleDto {

    private String roleId;

	private String roleName;

	private String roleDescription;

    private LocalDateTime createdDate;

    private LocalDateTime updatedDate;

}
