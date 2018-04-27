package com.securedweb.repository;

import org.springframework.data.repository.CrudRepository;

import com.securedweb.model.Test;

public interface TestRepository extends CrudRepository<Test, Integer>  {

}
