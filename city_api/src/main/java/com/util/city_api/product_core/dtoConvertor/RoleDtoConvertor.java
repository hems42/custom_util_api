package com.util.city_api.product_core.dtoConvertor;

import org.springframework.stereotype.Component;

import com.util.city_api.entity.primary.Role;
import com.util.city_api.product_core.dto.primaryDto.RoleDto;

@Component
public class RoleDtoConvertor {

	public Role convert(RoleDto from) {
		return new Role(
				from.getRoleId(),
				from.getRoleName(),
				from.getRoleDescription(),
	            from.getCreatedDate() == null ? null : from.getCreatedDate(),
	            from.getUpdatedDate() == null ? null : from.getUpdatedDate()       
				);
	}

	public RoleDto convert(Role from) {
		return new RoleDto(
				from.getRoleId(),
				from.getRoleName(),
				from.getRoleDescription(),
	            from.getCreatedDate() == null ? null : from.getCreatedDate(),
	            from.getUpdatedDate() == null ? null : from.getUpdatedDate()
				);
	}

}
