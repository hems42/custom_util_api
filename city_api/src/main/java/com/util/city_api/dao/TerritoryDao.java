package com.util.city_api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.util.city_api.entity.Territory;

public interface TerritoryDao extends JpaRepository<Territory,String> {

}
