package com.securedweb.dto;

import java.time.LocalDateTime;
import java.util.Set;

import com.securedweb.model.Hospital;
import com.securedweb.model.Occupancy;
import com.securedweb.model.Patient;

import lombok.Data;

@Data
public class RoomDto {
	
	private Integer id;
	private Occupancy occupancy;
	private Integer totalBeds;
	private Integer remainingBeds;
	private boolean vacantStatus;
	private Float perDayCharge;
	private Hospital hospital;
	private Set<Patient> patients;
	private LocalDateTime createDateTime;
	private LocalDateTime updateDateTime;
	
}
