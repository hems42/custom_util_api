package com.util.city_api.service.mockWorkbench;

import java.time.LocalDateTime;

import com.util.city_api.baseMockModel.BaseTestWorkBench;
import com.util.city_api.entity._core.User;
import com.util.city_api.entity.security.RefreshToken;
import com.util.city_api.product_core.dto._coreDto.UserDto;
import com.util.city_api.product_core.dtoConvertor.UserDtoConvertor;
import com.util.city_api.product_core.request.createRequest.UserCreateRequest;
import com.util.city_api.service._abstract.IAccesTokenService;
import com.util.city_api.service._abstract.IAuthService;
import com.util.city_api.service._abstract.IConfirmationTokenService;
import com.util.city_api.service._abstract.IRefreshTokenService;
import com.util.city_api.service._abstract.IUserService;

public class AuthServiceWorkBench extends BaseTestWorkBench{

	// service
	IAuthService authService;
	IUserService userService = getServiceModels().getUserService();
	IUserService mockUserService = getServiceModels().getMockUserService();
    IAccesTokenService accessTokenService = getServiceModels().getAccesTokenService();
    IAccesTokenService mockAccessTokenService = getServiceModels().getMockAccesTokenService();
    IRefreshTokenService refreshTokenService = getServiceModels().getRefreshTokenService();
    IRefreshTokenService mockRefreshTokenService = getServiceModels().getMockRefreshTokenService();
    IConfirmationTokenService confirmationTokenService = getServiceModels().getConfirmationtokenService();
    IConfirmationTokenService mockConfirmationTokenService = getServiceModels().getMockConfirmationTokenService();
    
    // convertor
  //  UserDtoConvertor userDtoConvertor = getDtoConvertorModels().getUserDtoConvertor();
  // UserDtoConvertor mockUserDtoConvertor = getDtoConvertorModels().getMockUserDtoConvertor();
	
    // model
    User userModel = getEntitymModels().getUser();
	//User mockUsermodel = getEntitymModels().getMockUserModel();
	//UserDto userDtoModel = getEntitymModels().getUserDtoModel();
	//UserDto mockUserDtoModel = getEntitymModels().getMockUserDtoModel();
	RefreshToken refreshTokenModel =getEntitymModels().getRefreshToken();
	UserCreateRequest userCreateRequestModel = getRequestRensponseModels().getUserCreateRequest();
	
	
	// util
	LocalDateTime time = getUtilityModels().getTime();
}
