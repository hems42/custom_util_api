package com.util.city_api.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.util.city_api.entity.primary.User;
import com.util.city_api.entity.security.RefreshToken;

public interface RefreshTokenDao extends JpaRepository<RefreshToken, String> {

	@Query( value = "SELECT r " +
            "FROM  RefreshToken r " +
            "WHERE r.user = ?1",
            nativeQuery = true 
            )
    RefreshToken getRefreshTokenByUser(User user);
	
	@Query( value = "SELECT r " +
            "FROM  RefreshToken r " +
            "WHERE r.refreshToken = ?1",
            nativeQuery = true 
            )
    RefreshToken getRefreshTokenByRefreshToken(String refreshToken);
}
