package com.example.demo.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	
	public String getsearchUserByName(String name) throws JsonProcessingException {
		List<User> users = userRepository.findByName(name);
		ObjectMapper mapper = new ObjectMapper();
	    String jsonInString = null;
	    jsonInString = mapper.writeValueAsString(users);
		return jsonInString;
	}
	
	public String getsearchUserById(String id) throws JsonProcessingException {
		System.out.println(id);
	    Optional<User> optionalUser = userRepository.findById(id);
	    
	    //Handling Null optionalUser
	    if(optionalUser.isPresent())
	    {
	    	 User user = optionalUser.get();
	 	    ObjectMapper mapper = new ObjectMapper();
	 	    String jsonInString = null;
	 	    jsonInString = mapper.writeValueAsString(user);
	 		return jsonInString;
	    }
	    else
	    {
	    	return "Data Not Found";
	    }
	   
	}
	
	public String getsearchbyProjectName(String project) throws JsonProcessingException {
		List<User> users = userRepository.findByProject(project);
		ObjectMapper mapper = new ObjectMapper();
	    String jsonInString = null;
	    return jsonInString = mapper.writeValueAsString(users);
}

	
	public String getsearchbyClickProject() throws JsonProcessingException {
		ArrayList<User> users = (ArrayList<User>) userRepository.findAll();
		Set<String> projects = new HashSet<String>(); 
		for(User u : users) {
			System.out.println(u.getProject().getClass().getName());
			projects.add(u.getProject());
		}
		ObjectMapper mapper = new ObjectMapper();
	    String jsonInString = null;
	    jsonInString = mapper.writeValueAsString(projects);
		return jsonInString;
	}
}