package com.example.demo.response.dto;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Component;

@SuppressWarnings("serial")
@Component
public class UserResponseDto implements Serializable {

	List<UserDto> users;

	public UserResponseDto() {
	}

	public List<UserDto> getUsers() {
		return users;
	}

	public void setUsers(List<UserDto> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "UserResponseDto [users=" + users + "]";
	}

}
