package com.blogapplicationapis.services;

import java.util.List;

import com.blogapplicationapis.entities.User;
import com.blogapplicationapis.payloads.UserDto;



public interface UserService {

	UserDto createUser(UserDto user);
	UserDto updateUser(UserDto userDto, Integer userId);
	UserDto getuserById(Integer userId);
	List<UserDto> getAllUsers();
	  void deleteUser(Integer userId);
	
	
	
}
