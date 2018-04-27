package com.securedweb.dto;

import java.time.LocalDateTime;

import com.securedweb.model.Hospital;
import com.securedweb.model.User;

import lombok.Data;

@Data
public class HospitalUserDto {
	
	private Integer id;
	private User user;
    private Hospital hospital;
	private LocalDateTime createDateTime;
	private LocalDateTime updateDateTime;
}
