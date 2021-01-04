package com.example.demo.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.example.demo.model.User;
import com.example.demo.response.dto.UserDto;
import com.example.demo.response.dto.UserResponseDto;

@Component
public class UserAssembler {

	public UserResponseDto toModel(List<User> users) {
		UserResponseDto userResponse = new UserResponseDto();
		if (CollectionUtils.isEmpty(users))
			return userResponse;
		else {
			List<UserDto> userDtos = users.parallelStream().map(element -> {
				UserDto user = new UserDto();
				user.setName(element.getName());
				user.setMail(element.getMail());
				user.setDesignation(element.getDesignation());
				user.setProject(element.getProject());
				user.setOracleid(element.getOracleid());
				user.setSeat(element.getSeat());
				user.setImg(element.getImg());
				user.setImgurl(element.getImgurl());
				user.setExtension(element.getExtension());
				user.setDu(element.getDu());
				return user;
			}).collect(Collectors.toList());
			userResponse.setUsers(userDtos);
		}
		return userResponse;
	}
}
