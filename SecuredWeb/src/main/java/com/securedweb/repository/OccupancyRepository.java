package com.securedweb.repository;

import org.springframework.data.repository.CrudRepository;

import com.securedweb.model.Occupancy;

public interface OccupancyRepository extends CrudRepository<Occupancy,Integer>{

	Occupancy findAllById(Integer id);

}
