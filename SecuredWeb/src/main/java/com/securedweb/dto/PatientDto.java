package com.securedweb.dto;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.securedweb.model.Appointment;
import com.securedweb.model.Doctor;
import com.securedweb.model.PatientStatus;
import com.securedweb.model.Room;
import com.securedweb.model.TestReport;
import com.securedweb.model.User;

import lombok.Data;

@Data
public class PatientDto {

    private Integer id;
	private User user;
	private Room room;
	private Doctor doctor;
	private PatientStatus patientStatus;
	private Date admittedDate;
	private Date discharedDate;
    private Set<Appointment> appointments = new HashSet<Appointment>();
    private Set<TestReport> testReports = new HashSet<TestReport>();
	private LocalDateTime createDateTime;
	private LocalDateTime updateDateTime;
}
