package com.example.demo.manage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping(value = "/search")
public class ManageUser {

	private UserRepository userRepository;
	
	@Autowired
	private UserService userService;

	@Autowired
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	//@RequestMapping(value = "/name",method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE })
	//public String searchUserByName(@RequestParam("name") String name) throws JsonProcessingException {
		/*
		 * List<User> users = userRepository.findByName(name); ObjectMapper mapper = new
		 * ObjectMapper(); String jsonInString = null; jsonInString =
		 * mapper.writeValueAsString(users); return jsonInString;
		 */
	//}
	
	@RequestMapping(value = "/name",method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE })
	  public ResponseEntity<String> searchUserByNames(@RequestParam("name") String name) throws JsonProcessingException 
		{
		String jsonInString= userService.getsearchUserByName(name); 
		HttpHeaders responseHeaders = new HttpHeaders(); 
		return new ResponseEntity<>(jsonInString,responseHeaders,HttpStatus.ACCEPTED); 
		}
	 
		
		//@RequestMapping(value = "/name",method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE })
	/*
	 * public String searchUserByNames(@RequestParam("name") String name) throws
	 * JsonProcessingException { String jsonInString=
	 * userService.getsearchUserByName(name); //HttpHeaders responseHeaders = new
	 * HttpHeaders(); return jsonInString; }
	 */
	

	@RequestMapping(value = "/id",method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> searchUserById(@RequestParam("id") String id) throws JsonProcessingException {
		String jsonInString = userService.getsearchUserById(id);
		HttpHeaders respHeaders= new HttpHeaders();
		System.out.println("jsonInString is:" +jsonInString);
		
		//Check if Data Found from the id provided
		if(jsonInString.equals("Data Not Found"))
		{
			return new ResponseEntity<>(jsonInString,respHeaders,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(jsonInString,respHeaders,HttpStatus.ACCEPTED);
	}

	@RequestMapping(value = "/project",method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE })
	public String searchbyProjectName(@RequestParam("project") String project) throws JsonProcessingException {
	    String jsonInString = userService.getsearchbyProjectName(project);
		return jsonInString;
	}
	
	@RequestMapping(value = "/allprojects",method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE })
	public String searchbyClickProject() throws JsonProcessingException {
		String jsonInString = userService.getsearchbyClickProject();
		return jsonInString;
	}
}
