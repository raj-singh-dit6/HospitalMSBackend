package com.securedweb.dto;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.securedweb.model.Hospital;
import com.securedweb.model.Patient;
import com.securedweb.model.Role;
import com.securedweb.model.UserSession;

import lombok.Data;

@Data
public class UserDto {

    private Integer id;
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private Date dob;
    private String email;
    private Long contact;
    private Set<Role> userRoles = new HashSet<Role>();
	private Hospital hospital;
	private Patient patient;
	private UserSession userSession;
	private LocalDateTime createDateTime;
	private LocalDateTime updateDateTime;
	
}
