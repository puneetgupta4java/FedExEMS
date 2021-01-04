package com.example.demo.manage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.assembler.UserAssembler;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.response.dto.UserResponseDto;
import com.example.demo.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping(value = "/search")
public class ManageUser {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserAssembler userAssembler;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/name",method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserResponseDto> searchUserByName(@RequestParam("name") String name) throws JsonProcessingException {
		List<User> users = userService.getUsersByName(name);
		UserResponseDto response = userAssembler.toModel(users);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@RequestMapping(value = "/id",method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE })
	public String searchUserById(@RequestParam("id") String id) throws JsonProcessingException {
		System.out.println(id);
	    Optional<User> optionalUser = userRepository.findById(id);
	    User user = optionalUser.get();
	    ObjectMapper mapper = new ObjectMapper();
	    String jsonInString = null;
	    jsonInString = mapper.writeValueAsString(user);
		return jsonInString;
	}

	@RequestMapping(value = "/project",method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE })
	public String searchbyProjectName(@RequestParam("project") String project) throws JsonProcessingException {
		List<User> users = userRepository.findByProject(project);
		ObjectMapper mapper = new ObjectMapper();
	    String jsonInString = null;
	    jsonInString = mapper.writeValueAsString(users);
		return jsonInString;
	}
	
	@RequestMapping(value = "/allprojects",method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE })
	public String searchbyClickProject() throws JsonProcessingException {
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
