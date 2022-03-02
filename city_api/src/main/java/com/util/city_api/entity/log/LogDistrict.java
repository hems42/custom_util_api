package com.util.city_api.entity.log;


import com.util.city_api.entity.City;
import com.util.city_api.entity.District;
import com.util.city_api.product_core.enums.EnumLogOperatıons;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "LogDistricts")
public class LogDistrict {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private EnumLogOperatıons crud;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CityId", nullable = false)
    private City city;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DistrictId", nullable = false)
    private District district;

    @Column(name = "CreatedDate", updatable = false)
    private LocalDateTime createdDate;
}
