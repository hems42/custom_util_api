package com.util.city_api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.util.city_api.entity._core.User;

public interface UserDao extends JpaRepository<User,String> {

}
