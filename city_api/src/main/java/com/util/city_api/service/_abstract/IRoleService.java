package com.util.city_api.service._abstract;

import com.util.city_api.core.constant.CoreEnumRoles;
import com.util.city_api.product_core.dto.primaryDto.RoleDto;

public interface IRoleService {

	// create
	RoleDto createRole(CoreEnumRoles role);
}
