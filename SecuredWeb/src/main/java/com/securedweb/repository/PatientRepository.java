package com.securedweb.repository;

import org.springframework.data.repository.CrudRepository;

import com.securedweb.model.Patient;

public interface PatientRepository extends CrudRepository<Patient, Integer>{

}
