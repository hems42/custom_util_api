package com.util.city_api.service._abstract;

import com.util.city_api.entity._core.User;
import com.util.city_api.entity.security.RefreshToken;

public interface IRefreshTokenService {

	RefreshToken createRefreshToken(User _user);

	RefreshToken saveRefreshToken(RefreshToken refreshToken);

	RefreshToken getRefreshTokenByUser(User _user); 

}
