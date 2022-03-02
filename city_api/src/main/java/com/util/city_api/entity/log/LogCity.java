package com.util.city_api.entity.log;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import com.util.city_api.entity.City;
import com.util.city_api.product_core.enums.EnumLogOperatıons;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "LogCities")
public class LogCity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private EnumLogOperatıons crud;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CityId", nullable = false)
    private City city;

    @Column(name = "CreatedDate", updatable = false)
    private LocalDateTime createdDate;
}
