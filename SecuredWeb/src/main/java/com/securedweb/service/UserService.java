package com.securedweb.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.securedweb.dto.UserDto;
import com.securedweb.model.User;
import com.securedweb.model.UserSession;
import com.securedweb.repository.UserRepository;
import com.securedweb.repository.UserSessionRepository;

@Service("userService")
public class UserService{

	private static final Logger LOG = LoggerFactory.getLogger(RoleService.class);
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserSessionRepository userSessRepository;
	
	@Autowired
	ModelMapper mapper;

	public boolean authenticate(String userName, String sessionKey) {
		User user = userRepository.findByUserName(userName);
		UserSession  userSession = userSessRepository.findByUserAndSessionKey(user, sessionKey);
		return userSession!=null;
	}
	
	public List<UserDto> getUsers() {
		List<User> hospList=(List<User>)userRepository.findAll();
		List<UserDto> hospDTOList = new ArrayList<UserDto>();
		for(User user:hospList)
		{
			hospDTOList.add(mapper.map(user, UserDto.class));
		}
		return hospDTOList;
	}

	public UserDto getUser(Integer id) {
		return mapper.map(userRepository.findById(id),UserDto.class);
	}
	
	
	public UserDto addUser(UserDto userDto) {
		userRepository.save(mapper.map(userDto,User.class));
		return userDto;
	}
	
	public UserDto updateUser(UserDto userDto) {
		User user= userRepository.findById(userDto.getId()).get();
		return userDto;
	}
	
	public void deleteUser(Integer id) {
		userRepository.deleteById(id);
	}

}

