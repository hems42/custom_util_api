package com.util.city_api.entity._core;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Towns")
public class Town {
	
		@Id
	    @GeneratedValue(generator = "UUID")
	    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	    private String townId;

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "DistrictId",referencedColumnName = "districtId")
	    private District district;
	    
	    @Column(name = "TownName",nullable = false,length = 100)
	    private String townName;
	    
	    @Column(name = "TownDescription",length = 200)
	    private String townDescription;
	    
	    @Column(name = "CreatedDate", updatable = false)
	    private LocalDateTime createdDate;

	    @Column(name = "UpdatedDate", insertable = false)
	    private LocalDateTime updatedDate;

}
