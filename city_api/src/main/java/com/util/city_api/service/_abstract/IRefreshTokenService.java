package com.util.city_api.service._abstract;

import com.util.city_api.entity._core.User;
import com.util.city_api.entity.security.RefreshToken;

public interface IRefreshTokenService {

	RefreshToken createRefreshToken(User user);

	RefreshToken saveRefreshToken(RefreshToken refreshToken);

	RefreshToken getRefreshTokenByUser(User user);

	RefreshToken getRefreshTokenByRefreshToken(String refreshToken);

	Boolean verifyRefreshToken(String refreshToken);

	void deleteRefreshTokenByRefreshToken(RefreshToken refreshToken); 

}
