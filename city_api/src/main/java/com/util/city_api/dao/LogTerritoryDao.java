package com.util.city_api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.util.city_api.entity.log.LogTerritory;

public interface LogTerritoryDao extends JpaRepository<LogTerritory,String> {

}
