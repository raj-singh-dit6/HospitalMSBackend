package com.securedweb.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class OccupancyDto {
	
	private Integer id;
	private String type;
	private LocalDateTime createDateTime;
	private LocalDateTime updateDateTime;
}
