package com.util.city_api.dao;

import java.util.List;

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

    @Query( "SELECT * " +
            "FROM User u " +
            "WHERE u.isActive = ?1")
    List<User> getAllUsersByIsActive(Boolean isActive);
    
    @Query( "SELECT * " +
            "FROM User u " +
            "WHERE u.isBlocked = ?1")
    List<User> getAllUsersByIsBlocked(Boolean isBlocked);
    
    @Query( "SELECT * " +
            "FROM User u " +
            "WHERE u.isRegistered = ?1")
    List<User> getAllUsersByIsRegistered(Boolean isRegistered);
    
}
