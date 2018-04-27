package com.securedweb.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.securedweb.model.Hospital;
import com.securedweb.model.Room;

public interface RoomRepository extends CrudRepository<Room, Integer>{

	List<Room> findAllByHospital(Hospital hospital);

}
