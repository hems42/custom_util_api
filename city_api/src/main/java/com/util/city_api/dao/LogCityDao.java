package com.util.city_api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.util.city_api.entity.log.LogCity;

public interface LogCityDao extends JpaRepository<LogCity,String> {
}
