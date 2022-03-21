package com.util.city_api.entity.log;


import com.util.city_api.entity._core.District;
import com.util.city_api.entity._core.User;
import com.util.city_api.product_core.enums.EnumLogOperations;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "LogDistricts")
public class LogDistrict {

	@Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String logDistrictId;

	@Enumerated(EnumType.STRING)
    @Column(name = "TypeOfTransaction", nullable = false)
    private EnumLogOperations transactionType;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DistrictId", nullable = false)
	private District district;

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PerformedTransactionBy", nullable = false)
    private User PerformingTransactionBy;

    @Column(name = "CreatedDate", updatable = false)
    private LocalDateTime createdDate;

}
