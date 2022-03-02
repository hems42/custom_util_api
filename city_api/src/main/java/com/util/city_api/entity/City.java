package com.util.city_api.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Cities")
public class City {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cityId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TerritoryId",nullable = false, referencedColumnName = "territoryId")
	private Territory territory;

    @Column(name = "CityName",nullable = false,length = 100)
    private String cityName;

    @Column(name = "PlateCode",nullable = false,length = 15, unique = true)
    private String plateCode;

    @Column(name = "PostCode",nullable = false,length = 15, unique = true)
    private String posteCode;

    @Column(name = "PhonoNumberCode",nullable = false,length = 15, unique = true)
    private String phoneNumberCode;
    
    @Column(name = "CityDescription",length = 200)
    private String cityDescription;

    @Column(name = "CreatedDate", updatable = false)
    private LocalDateTime createdDate;

    @Column(name = "UpdatedDate", insertable = false)
    private LocalDateTime updatedDate;
    
}
