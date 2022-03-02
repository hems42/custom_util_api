package com.util.city_api.product_core.dtoConvertor;

import java.util.HashSet;

import org.springframework.stereotype.Component;

import com.util.city_api.entity._core.User;
import com.util.city_api.product_core.dto._coreDto.UserDto;

@Component
public class UserDtoConvertor {

    public User convert(UserDto from) {
        return new User(
                from.getUserId(),
                from.getUserName(),
                from.getEMail(),
                from.getPassword(),
                from.getIsActive(),
                from.getIsBlocked(),
                from.getIsRegistered(),
                from.getRoles() == null ? new HashSet<>() : from.getRoles(),
                from.getCreatedDate() == null ? null : from.getCreatedDate(),
                from.getUpdatedDate() == null ? null : from.getUpdatedDate()
        );
    }

    public UserDto convert(User from) {
        return new UserDto(
        		from.getUserId(),
                from.getUserName(),
                from.getEMail(),
                from.getPassword(),
                from.getIsActive(),
                from.getIsBlocked(),
                from.getIsRegistered(),
                from.getRoles() == null ? new HashSet<>() : from.getRoles(),
                from.getCreatedDate() == null ? null : from.getCreatedDate(),
                from.getUpdatedDate() == null ? null : from.getUpdatedDate()

        );
    } }
