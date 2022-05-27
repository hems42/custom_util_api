package com.util.city_api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.util.city_api.entity.primary.District;

public interface DistrictDao extends JpaRepository<District,String> {
}
