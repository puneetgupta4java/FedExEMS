package com.example.demo.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.example.demo.exception.UserException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public List<User> getUsersByName(String name) {
		if(name.isEmpty() || name.trim().isEmpty()) {
			throw new UserException("User name cannot be null or empty");
		}
		List<User> users = userRepository.findByName(name);
		if(CollectionUtils.isEmpty(users)) {
			throw new UserException("User name not found in database");
		}
		return users;
	}

	
}
