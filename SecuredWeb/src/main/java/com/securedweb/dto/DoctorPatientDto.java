package com.securedweb.dto;

import java.time.LocalDateTime;

import com.securedweb.model.Doctor;
import com.securedweb.model.Patient;

import lombok.Data;

@Data
public class DoctorPatientDto{

	private Integer id;
	private Doctor doctor;
    private Patient patient;
	private LocalDateTime createDateTime;
	private LocalDateTime updateDateTime;
}
