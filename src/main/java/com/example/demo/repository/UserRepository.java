package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.User;


public interface UserRepository  extends JpaRepository<User,String>{

	List<User> findByName(String emp_name);
	
	//Optional<User> findById(String emp_id);
	
	List<User> findByProject(String emp_project);
	
}
