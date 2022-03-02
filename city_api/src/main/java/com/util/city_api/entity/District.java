package com.util.city_api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Districts")
public class District {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long districtId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CityId",nullable = false, referencedColumnName = "cityId")
    private City city;

    @Column(name = "DistrictName",nullable = false,length = 100)
    private String districtName;

    @Column(name = "PostCode",nullable = false,length = 15)
    private String postCode;

    @Column(name = "DistrictDescription",length = 200)
    private String districtDescription;
    
    @Column(name = "CreatedDate", updatable = false)
    private LocalDateTime createdDate;

    @Column(name = "UpdatedDate", insertable = false)
    private LocalDateTime updatedDate;
}
