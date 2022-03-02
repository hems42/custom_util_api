package com.util.city_api.entity._core;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Users")
public class User {
	
	@Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String userId;
	
    @Column(name = "UserName", nullable = false, length = 50, unique = true)
    private String userName;

    @Column(name = "Email", nullable = false, length = 50, unique = true)
    private String eMail;

    @Column(name = "Password", nullable = false, length = 250)
    private String password;

    @Column(name = "IsActive", nullable = false)
    private Boolean isActive;

    @Column(name = "IsBlocked", nullable = false)
    private Boolean isBlocked;
    
    @Column(name = "IsRegistered", nullable = false)
    private Boolean isRegistered;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "USER_ROLE",
            joinColumns = {@JoinColumn(name = "UserId")},
            inverseJoinColumns = {@JoinColumn(name = "RoleId")}
    )
    private Set<Role> roles = new HashSet<>();

    @Column(name = "CreatedDate", updatable = false)
    private LocalDateTime createdDate;

    @Column(name = "UpdatedDate", insertable = false)
    private LocalDateTime updatedDate;

}
