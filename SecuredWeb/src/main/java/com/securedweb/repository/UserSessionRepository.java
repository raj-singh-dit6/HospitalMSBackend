package com.securedweb.repository;

import org.springframework.data.repository.CrudRepository;

import com.securedweb.model.User;
import com.securedweb.model.UserSession;

public interface UserSessionRepository extends CrudRepository<UserSession, Integer>{

	UserSession findByUser(User user);

	UserSession findByUserAndSessionKey(User user, String sessionKey);

	UserSession findByUserAndSessionKey(String userName, String sessionKey);

}
