package com.util.city_api.service.concrete;

import org.springframework.stereotype.Service;

import com.util.city_api.dao.RoleDao;
import com.util.city_api.service._abstract.IRoleService;

@Service
public class RoleService implements IRoleService {
	
	private final RoleDao roleRepository;
	
	public RoleService(RoleDao roleDao)
	{
		this.roleRepository = roleDao;
	}

}
