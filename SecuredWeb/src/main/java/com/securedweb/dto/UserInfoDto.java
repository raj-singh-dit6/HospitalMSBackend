package com.securedweb.dto;

import java.util.Set;

import com.securedweb.model.Role;

import lombok.Data;

@Data
public class UserInfoDto {
	
	private Integer id;
	private String userName;
	private String firstName;
	private String lastName;
	private String email;
	private String contact;
	private Set<Role> roles;
	private String sessionKey;

}
