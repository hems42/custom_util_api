package com.util.city_api.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.util.city_api.entity._core.User;
import com.util.city_api.entity.security.RefreshToken;

public interface RefreshTokenDao extends JpaRepository<RefreshToken, String> {

	@Query( value = "SELECT r " +
            "FROM  RefreshToken r " +
            "WHERE r.user = ?1",
            nativeQuery = true 
            )
    RefreshToken getRefreshTokenByuser(User user);
}
