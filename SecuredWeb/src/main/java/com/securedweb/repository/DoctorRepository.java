package com.securedweb.repository;

import org.springframework.data.repository.CrudRepository;

import com.securedweb.model.Doctor;

public interface DoctorRepository extends CrudRepository<Doctor, Integer> {

}
