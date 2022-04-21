package com.util.city_api.product_core.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor 
@AllArgsConstructor
public class RefreshTokenResponse {

	private String refreshToken;
    private String accessToken;
    private Boolean isValid;
    private Boolean isChanged;

}
