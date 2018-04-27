package com.securedweb.repository;

import org.springframework.data.repository.CrudRepository;

import com.securedweb.model.PatientStatus;

public interface PatientStatusRepository extends CrudRepository<PatientStatus, Integer>{

}
