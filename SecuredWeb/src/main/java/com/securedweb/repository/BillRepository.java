package com.securedweb.repository;

import org.springframework.data.repository.CrudRepository;

import com.securedweb.model.Bill;

public interface BillRepository extends CrudRepository<Bill, Integer>{

}
