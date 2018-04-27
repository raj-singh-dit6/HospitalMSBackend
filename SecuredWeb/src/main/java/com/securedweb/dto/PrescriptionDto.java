package com.securedweb.dto;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.securedweb.model.Doctor;
import com.securedweb.model.Document;
import com.securedweb.model.Patient;

import lombok.Data;

@Data
public class PrescriptionDto {

	private Integer id;
	private Doctor doctor;
	private Patient patient;
	private Set<Document> document;
	private LocalDateTime createDateTime;
	private LocalDateTime updateDateTime;
}
