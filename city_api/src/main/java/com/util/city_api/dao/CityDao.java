package com.util.city_api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.util.city_api.entity._core.City;

public interface CityDao extends JpaRepository<City,String> {
}
