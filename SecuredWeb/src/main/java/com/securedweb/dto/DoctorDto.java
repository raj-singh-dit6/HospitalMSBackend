package com.securedweb.dto;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import com.securedweb.model.Appointment;
import com.securedweb.model.Department;
import com.securedweb.model.Patient;
import com.securedweb.model.User;

import lombok.Data;

@Data
public class DoctorDto {

    private Integer id;
	private User user;
	private String description;
	private boolean active;
    private Set<Appointment> appointments = new HashSet<Appointment>();
	private Department department;
	private Set<Patient> patients;
	private LocalDateTime createDateTime;
	private LocalDateTime updateDateTime;
	
}
