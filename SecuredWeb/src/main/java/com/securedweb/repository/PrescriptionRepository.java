package com.securedweb.repository;

import org.springframework.data.repository.CrudRepository;

import com.securedweb.model.Prescription;

public interface PrescriptionRepository extends CrudRepository<Prescription, Integer> {

}
