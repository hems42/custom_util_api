package com.util.city_api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.util.city_api.entity.security.ConfirmationToken;

public interface ConfirmationTokenDao extends JpaRepository<ConfirmationToken,String>{

}
