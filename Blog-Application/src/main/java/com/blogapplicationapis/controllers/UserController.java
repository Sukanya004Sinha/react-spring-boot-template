package com.blogapplicationapis.controllers;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogapplicationapis.payloads.ApiResponse;
import com.blogapplicationapis.payloads.UserDto;
import com.blogapplicationapis.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	@Autowired
	private UserService userService;
	//Post -create user
	@PostMapping("/")
	
	public ResponseEntity<UserDto> creteUser(@Validated @RequestBody UserDto userDto){
		UserDto createUserDto= this.userService.createUser(userDto);
		return new ResponseEntity<>(createUserDto,HttpStatus.CREATED);
	}
	//PUT - update user
	@PutMapping("/{userId}") 
//	above is called path URI variable
	public ResponseEntity<UserDto> updateUser(@Validated @RequestBody UserDto userDto, @PathVariable("userId") Integer uid){
		UserDto updatedUser=this.userService.updateUser(userDto, uid);
		return ResponseEntity.ok(updatedUser);
		
	}
	//Delete- delete user
	@DeleteMapping("/{userId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable ("userId")Integer uid){
		this.userService.deleteUser(uid);
return new ResponseEntity<ApiResponse>(new ApiResponse("User Deleted Successfully",true),HttpStatus.OK);
	}
//get - user get
	@GetMapping("/")
	public ResponseEntity<java.util.List<UserDto>> getAllUsers(){
		return ResponseEntity.ok(this.userService.getAllUsers());
	}
	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> getSingleUser(@PathVariable Integer userId){
		return ResponseEntity.ok(this.userService.getuserById(userId));
		

	}
	

}
