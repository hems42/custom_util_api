package com.util.city_api.baseMock;

import org.mockito.Mockito;

import com.util.city_api.entity._core.User;
import com.util.city_api.product_core.dto._coreDto.UserDto;
import com.util.city_api.product_core.dtoConvertor.LogRoleDtoConvertor;
import com.util.city_api.product_core.dtoConvertor.LogUserDtoConvertor;
import com.util.city_api.product_core.dtoConvertor.RoleDtoConvertor;
import com.util.city_api.product_core.dtoConvertor.UserDtoConvertor;
import com.util.city_api.product_core.request.createRequest.SignupRequest;
import com.util.city_api.product_core.request.createRequest.UserCreateRequest;
import com.util.city_api.product_core.response.SignupReponse;
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

public class BaseMockServiceAndServiceAndRequestModel extends BaseMockDaoAndDao{

	final private BaseEntityAndDtoTestModel models = new BaseEntityAndDtoTestModel();
	
	
	
	// request model
	
	public SignupRequest getSignupRequestModel() {
		return new SignupRequest("username","email@email","password","");
	}
	
	public UserCreateRequest getUserCreateRequest(){
		return new UserCreateRequest("username","email@email","password"); 
	}
	
	
	
	
	// response model
	
	public SignupReponse getSignupResponse() { 
		return new SignupReponse(
				"username",
				"email",
				"accessToken",
				"refreshToken",
				"expireTimeAccessToken",
				"expireTimeRefreshToken");
	}
	
	
	
	
	// entity and dto model
	
	public User getUserModel() {
		return models.getUser();
	}
	
	public User getMockUserModel() {
		return Mockito.mock(User.class);
	}
	
	public UserDto getUserDtoModel() {
		return models.getUserDto();
	}
	
	public UserDto getMockUserDtoModel() {
		return Mockito.mock(UserDto.class);
	}
	
	
	
	
	
	// dto convertor
	public UserDtoConvertor getUserDtoConvertor() {
		return new UserDtoConvertor();
	}
	
	public UserDtoConvertor getMockUserDtoConvertor() {
		return Mockito.mock(UserDtoConvertor.class);
	}
	
	public LogUserDtoConvertor getLogUserDtoConvertor() {
		return new LogUserDtoConvertor();
	}
	
	public LogUserDtoConvertor getMockLogUserDtoConvertor() {
		return Mockito.mock(LogUserDtoConvertor.class);
	}
	
	public RoleDtoConvertor getRoleDtoConvertor() {
		return new RoleDtoConvertor();
	}
	
	public RoleDtoConvertor getMockRoleDtoConvertor() {
		return Mockito.mock(RoleDtoConvertor.class);
	}
	
	public LogRoleDtoConvertor getLogRoleDtoconvertor() {
		return new LogRoleDtoConvertor();
	}
	
	public LogRoleDtoConvertor getMockLogRoleDtoconvertor() {
		return Mockito.mock(LogRoleDtoConvertor.class);
	}
	
	
	
	// authentication service 
	
	public IAccesTokenService getAccesTokenService() {
		return new AccesTokenService();
	}
	
	public IAccesTokenService getMockAccesTokenService() {
		return Mockito.mock(AccesTokenService.class);
	}
	
	public IRefreshTokenService getRefreshTokenService() {
		return new RefreshTokenService();
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
	
	public IUserService getUserService() {
		return new UserService(getUserDao(),
				getUserDtoConvertor(),
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
	


}
