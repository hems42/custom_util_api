package com.util.city_api.baseMockModel;

import org.mockito.Mockito;

import com.util.city_api.dao.RefreshTokenDao;
import com.util.city_api.product_core.dtoConvertor.UserDtoConvertor;
import com.util.city_api.service._abstract.IAccesTokenService;
import com.util.city_api.service._abstract.IConfirmationTokenService;
import com.util.city_api.service._abstract.ILogRoleService;
import com.util.city_api.service._abstract.ILogUserService;
import com.util.city_api.service._abstract.IRefreshTokenService;
import com.util.city_api.service._abstract.IRoleService;
import com.util.city_api.service._abstract.IUserService;
import com.util.city_api.service.concrete.AccesTokenService;
import com.util.city_api.service.concrete.ConfirmationTokenService;
import com.util.city_api.service.concrete.LogUserService;
import com.util.city_api.service.concrete.RefreshTokenService;
import com.util.city_api.service.concrete.RoleService;
import com.util.city_api.service.concrete.UserService;

public class BaseMockServiceAndServiceModel extends BaseMockDaoAndDaoModel{
	
	// authentication service 
	
	public IAccesTokenService getAccesTokenService() {
		return new AccesTokenService();
	}
	
	public IAccesTokenService getMockAccesTokenService() {
		return Mockito.mock(AccesTokenService.class);
	}
	
	public IRefreshTokenService getRefreshTokenService(RefreshTokenDao refreshTokenDao) {
		return new RefreshTokenService(refreshTokenDao);
	}
	
	public IRefreshTokenService getMockRefreshTokenService() {
		return Mockito.mock(RefreshTokenService.class);
	}
	
	public IConfirmationTokenService getConfirmationtokenService() {
		return new ConfirmationTokenService();
	}
	
	public IConfirmationTokenService getMockConfirmationTokenService() {
		return Mockito.mock(ConfirmationTokenService.class);
	}

	
	// log entity service
	
	public ILogUserService getLogUserService() {
		return new LogUserService(getLogUserDao());
	}

	public ILogUserService getMockLogUserService() {
		return Mockito.mock(LogUserService.class);
	}
	
	public ILogRoleService getLogRoleService() {
		return null;
	}
	
	public ILogRoleService getMockLogRoleService() {
		return Mockito.mock(ILogRoleService.class);
	}
	
	
	// entity service
	
	public IUserService getUserService(UserDtoConvertor userDtoConvertor) {
		return new UserService(getUserDao(),
				userDtoConvertor,
				getLogUserService());
	}
	
	public IUserService getMockUserService() { 
		return Mockito.mock(UserService.class);
	}
	
	public IRoleService getRoleService() {
		return new RoleService(getRoleDao());
	}
	
	public IRoleService getMockRoleService() {
		return Mockito.mock(RoleService.class);
	}
	
		
	
	// constructor
	private static BaseMockServiceAndServiceModel _baseMockServiceAndServiceModel;
	
	public BaseMockServiceAndServiceModel() {}
    
    public static BaseMockServiceAndServiceModel getInstance()
    {
    	if(_baseMockServiceAndServiceModel==null)
    	{
    		_baseMockServiceAndServiceModel = new BaseMockServiceAndServiceModel();
    	}
    	return _baseMockServiceAndServiceModel;
    }
}
