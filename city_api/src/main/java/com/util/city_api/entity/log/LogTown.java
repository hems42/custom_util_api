package com.util.city_api.entity.log;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.util.city_api.entity._core.Town;
import com.util.city_api.entity._core.User;
import com.util.city_api.product_core.enums.EnumLogOperatıons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "LogTowns")
public class LogTown {

	@Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String logTownId;

	@Enumerated(EnumType.STRING)
    @Column(name = "TypeOfTransaction", nullable = false)
    private EnumLogOperatıons transactionType;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TownId", nullable = false)
	private Town town;

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PerformedTransactionBy", nullable = false)
    private User PerformingTransactionBy;

    @Column(name = "CreatedDate", updatable = false)
    private LocalDateTime createdDate;
}
