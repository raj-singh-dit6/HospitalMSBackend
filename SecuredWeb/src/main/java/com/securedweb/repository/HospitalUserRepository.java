package com.securedweb.repository;

import org.springframework.data.repository.CrudRepository;

import com.securedweb.model.Hospital;

public interface HospitalUserRepository extends CrudRepository<Hospital, Integer> {

}
