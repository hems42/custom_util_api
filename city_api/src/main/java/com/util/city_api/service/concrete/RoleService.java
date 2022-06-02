package com.util.city_api.service.concrete;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.util.city_api.core.constant.CoreEnumRoles;
import com.util.city_api.dao.RoleDao;
import com.util.city_api.entity.primary.Role;
import com.util.city_api.product_core.dto.primaryDto.RoleDto;
import com.util.city_api.product_core.dtoConvertor.RoleDtoConvertor;
import com.util.city_api.service._abstract.IRoleService;

@Service
public class RoleService implements IRoleService {
	
	private final RoleDao roleRepository;
	private final RoleDtoConvertor roleDtoConvertor;
	
	public RoleService(RoleDao roleDao, RoleDtoConvertor roleDtoConvertor)
	{
		this.roleRepository = roleDao;
		
		this.roleDtoConvertor = roleDtoConvertor;
	}

	
	@Override
	public RoleDto createRole(CoreEnumRoles role) {
		
	Role roleCreated =	roleRepository.save(new Role(
				null,
				role.getRoleName(),
				role.getRoleDescription(),
				LocalDateTime.now(),
				null));
	
		return roleDtoConvertor.convert(roleCreated);
	}

}
