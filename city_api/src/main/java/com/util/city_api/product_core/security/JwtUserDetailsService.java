package com.util.city_api.product_core.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.util.city_api.product_core.dtoConvertor.UserDtoConvertor;
import com.util.city_api.service._abstract.IUserService;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	private final IUserService userService;
    private final UserDtoConvertor userDtoConvertor;

    public JwtUserDetailsService(IUserService userService, UserDtoConvertor userDtoConvertor) {
        this.userService = userService;
        this.userDtoConvertor = userDtoConvertor;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {   	
    	return new JwtUserDetail(userDtoConvertor.convert(userService.getUserByUserName(username)));        
    }
}