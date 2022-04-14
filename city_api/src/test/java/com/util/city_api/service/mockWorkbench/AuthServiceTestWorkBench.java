package com.util.city_api.service.mockWorkbench;

import java.time.LocalDateTime;
import java.util.HashSet;

import com.util.city_api.baseMockModel.BaseMockDtoConvertorAndDtoConvertorModel;
import com.util.city_api.baseMockModel.BaseMockEntity_DtoAndEntity_DtoModel;
import com.util.city_api.baseMockModel.BaseMockRequest_ResponseAndRequest_ResponseModel;
import com.util.city_api.baseMockModel.BaseTestWorkBench;
import com.util.city_api.entity._core.Role;
import com.util.city_api.entity._core.User;
import com.util.city_api.entity.security.RefreshToken;
import com.util.city_api.product_core.dto._coreDto.UserDto;
import com.util.city_api.product_core.dtoConvertor.UserDtoConvertor;
import com.util.city_api.product_core.request.createRequest.SignupRequest;
import com.util.city_api.product_core.request.createRequest.UserCreateRequest;
import com.util.city_api.service._abstract.IAccesTokenService;
import com.util.city_api.service._abstract.IAuthService;
import com.util.city_api.service._abstract.IConfirmationTokenService;
import com.util.city_api.service._abstract.IRefreshTokenService;
import com.util.city_api.service._abstract.IUserService;

public class AuthServiceTestWorkBench extends BaseTestWorkBench{

	private BaseMockEntity_DtoAndEntity_DtoModel entityModel = getEntityDtoModels();
	private BaseMockRequest_ResponseAndRequest_ResponseModel requestResponsemodel = getRequestRensponseModels();
	private BaseMockDtoConvertorAndDtoConvertorModel dtoConvertorModel = getDtoConvertorModels();
	
	public LocalDateTime localDateTime = getUtilityModels().getTime();
	
	public HashSet<Role> roles;
	
    // model
	public User userModel = entityModel.getUser(roles,localDateTime,localDateTime);
	//User mockUsermodel = entityModel.getMockUserModel(roles,localDateTime,localDateTime);
    public UserDto userDtoModel = entityModel.getUserDto(roles,localDateTime,localDateTime);
	//UserDto mockUserDtoModel = getEntitymModels().getMockUserDtoModel();
	public RefreshToken refreshTokenModel =requestResponsemodel.getRefreshToken(userModel,localDateTime,localDateTime);
	public UserCreateRequest userCreateRequestModel = requestResponsemodel.getUserCreateRequest();
	public SignupRequest signupRequestModel = requestResponsemodel.getSignupRequestModel();
	
    // convertor
	public UserDtoConvertor userDtoConvertor = dtoConvertorModel.getUserDtoConvertor();
	public UserDtoConvertor mockUserDtoConvertor = dtoConvertorModel.getMockUserDtoConvertor();

	
	// service
	public IAuthService authService;
	public IUserService userService = getServiceModels().getUserService(userDtoConvertor);
	public IUserService mockUserService = getServiceModels().getMockUserService();
	public IAccesTokenService accessTokenService = getServiceModels().getAccesTokenService();
	public IAccesTokenService mockAccessTokenService = getServiceModels().getMockAccesTokenService();
	public IRefreshTokenService refreshTokenService = getServiceModels().getRefreshTokenService();
	public IRefreshTokenService mockRefreshTokenService = getServiceModels().getMockRefreshTokenService();
	public IConfirmationTokenService confirmationTokenService = getServiceModels().getConfirmationtokenService();
	public IConfirmationTokenService mockConfirmationTokenService = getServiceModels().getMockConfirmationTokenService();

}
