
package com.blogapplicationapis.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogapplicationapis.payloads.UserDto;
import com.blogapplicationapis.repositories.UserRepo;
import com.blogapplicationapis.services.UserService;
import com.blogapplicationapis.entities.*;
import com.blogapplicationapis.exceptions.*;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
	private  UserRepo  userRepo;
    
    @Autowired
    private ModelMapper modelMapper;
	@Override
	public UserDto createUser(UserDto userDto) {
		// TODO Auto-generated method stub
		User user = this.dtoToUser(userDto);
		User savedUser=this.userRepo.save(user);
		return this.userToDto(savedUser);
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
		User user = this.userRepo.findById(userId)
				.orElseThrow(()-> new ResourceNotFoundException("user","Id",userId));
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());
		
		User updateduser = this.userRepo.save(user);
		UserDto userDto1= this.userToDto(updateduser);
		return userDto1;
		
	}

	@Override
	public UserDto getuserById(Integer userId) {
		User user= this.userRepo.findById(userId)
				.orElseThrow(()-> new ResourceNotFoundException("user", "Id", userId));
		
		// TODO Auto-generated method stub
		return this.userToDto(user);
	}

	@Override
	public List<UserDto> getAllUsers() {
		// TODO Auto-generated method stub
		List<User> users= this.userRepo.findAll();
		List<UserDto> userDtos= users.stream().map(user->this.userToDto(user)).collect(Collectors.toList());
		return userDtos;
		
	}

	@Override
	public void deleteUser(Integer userId) {
		User user= this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","Id",userId));
		this.userRepo.delete(user);
		// TODO Auto-generated method stub

	}
	private User dtoToUser(UserDto userDto) {
		User user = this.modelMapper.map(userDto, User.class);
//		user.setId(userDto.getId());
//		user.setName(userDto.getName());
//		user.setEmail(userDto.getEmail());
//		user.setAbout(userDto.getAbout());
//		user.setPassword(userDto.getPassword());
//		instead of this we are using Modelmapper as above
		
		return user;
		
	}
public UserDto userToDto(User user) {
//	UserDto userDto = new UserDto();
	UserDto userDto = this.modelMapper.map(user,UserDto.class);
//	userDto.setId(user.getId());
//	userDto.setName(user.getName());
//	userDto.setEmail(user.getEmail());
//	userDto.setAbout(user.getAbout());
//	userDto.setPassword(user.getPassword());
	//here we are changing user into userDTO
	
	
	return userDto;
	
}

}







