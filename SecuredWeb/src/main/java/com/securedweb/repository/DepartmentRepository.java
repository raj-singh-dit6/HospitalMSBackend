package com.securedweb.repository;

import org.springframework.data.repository.CrudRepository;

import com.securedweb.model.Department;

public interface DepartmentRepository extends CrudRepository<Department, Integer> {

}
