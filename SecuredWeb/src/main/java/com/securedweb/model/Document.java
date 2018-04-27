
package com.securedweb.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Data
public class Document implements Serializable{

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id; 
     
    @Column(length=100, nullable=false)
    private String name;
     
    @Column(length=255)
    private String description;
     
    @Column(length=100, nullable=false)
    private String type;
     
    @Column(length=255, nullable=false)
    private String location;
    
    @ManyToOne(optional = true)
    @JoinColumn(name = "prescription_id")
    private Prescription  prescription;
     
	@CreationTimestamp
	private LocalDateTime createDateTime;

	@UpdateTimestamp
	private LocalDateTime updateDateTime;
	
} 
