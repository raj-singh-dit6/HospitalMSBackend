package com.securedweb.repository;

import org.springframework.data.repository.CrudRepository;

import com.securedweb.model.User;

public interface UserRepository extends CrudRepository<User, Integer>{

	User findByUserName(String userName);

}