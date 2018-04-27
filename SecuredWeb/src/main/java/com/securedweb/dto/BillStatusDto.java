package com.securedweb.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class BillStatusDto {

	private Integer id;
	private String name;
	private LocalDateTime createDateTime;
	private LocalDateTime updateDateTime;
}
