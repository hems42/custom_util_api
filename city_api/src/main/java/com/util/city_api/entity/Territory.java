package com.util.city_api.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Territories")
public class Territory {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long territoryId;
	
	@Column(name = "TerritoryName",nullable = false, length = 100,unique = true)
	private String territoryName;
	
	@Column(name = "TerritoryDescription",length = 200)
    private String territoryDescription;
	
    @Column(name = "CreatedDate", updatable = false)
    private LocalDateTime createdDate;

    @Column(name = "UpdatedDate", insertable = false)
    private LocalDateTime updatedDate; }
