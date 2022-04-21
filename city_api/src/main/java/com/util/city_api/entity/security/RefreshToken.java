package com.util.city_api.entity.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import com.util.city_api.entity._core.User;

import java.time.Instant;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor 
@AllArgsConstructor
@Entity(name = "RefreshTokens")
public class RefreshToken {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private String tokenId;

  @OneToOne
  @JoinColumn(name = "UserId", referencedColumnName = "userId", unique = true)
  private User user;

  @Column(nullable = false, unique = true)
  private String refreshToken;

  @Column(nullable = false)
  private LocalDateTime expiryDate;

  @Column(name = "CreatedDate", updatable = false)
  private LocalDateTime createdDate;
}