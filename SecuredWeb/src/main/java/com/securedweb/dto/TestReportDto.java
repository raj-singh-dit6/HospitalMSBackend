package com.securedweb.dto;

import java.time.LocalDateTime;

import com.securedweb.model.Bill;
import com.securedweb.model.Patient;
import com.securedweb.model.Test;

import lombok.Data;

@Data
public class TestReportDto {

    private Integer id;
	private Test test;
	private String description;
	private Patient patient;
	private Bill bill;
	private LocalDateTime createDateTime;
	private LocalDateTime updateDateTime;
}
