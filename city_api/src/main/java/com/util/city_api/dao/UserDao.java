package com.util.city_api.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.util.city_api.entity._core.User;

public interface UserDao extends JpaRepository<User,String> {

    @Query( "SELECT u " +
            "FROM User u " +
            "WHERE u.eMail = ?1")
    User getUserByEmail(String email);

    @Query( "SELECT u " +
            "FROM User u " +
            "WHERE u.userName = ?1")
    User getUserByNickName(String userName);

    @Query( "SELECT u " +
            "FROM User u " +
            "WHERE u.userName = ?1 or u.eMail = ?2")
    User getUserByNickNameOrEmail(String userName, String email);
}
