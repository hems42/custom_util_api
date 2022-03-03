package com.util.city_api.entity.log;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import com.util.city_api.entity._core.City;
import com.util.city_api.entity._core.User;
import com.util.city_api.product_core.enums.EnumLogOperatıons;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "LogCities")
public class LogCity {

	@Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String logCityId;

	@Enumerated(EnumType.STRING)
    @Column(name = "TypeOfTransaction", nullable = false)
    private EnumLogOperatıons transactionType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CityId", nullable = false)
    private City city;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PerformedTransactionBy", nullable = false)
    private User PerformingTransactionBy;
    
    @Column(name = "CreatedDate", updatable = false)
    private LocalDateTime createdDate;
}
