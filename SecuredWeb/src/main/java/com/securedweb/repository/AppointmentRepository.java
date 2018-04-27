package com.securedweb.repository;

import org.springframework.data.repository.CrudRepository;

import com.securedweb.model.Appointment;

public interface AppointmentRepository extends CrudRepository<Appointment, Integer>{

}
