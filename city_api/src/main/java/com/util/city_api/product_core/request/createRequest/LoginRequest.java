package com.util.city_api.product_core.request.createRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor 
@AllArgsConstructor
public class LoginRequest {

    private String userName;
    private String email;
    private String password;
}
