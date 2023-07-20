package com.codeWithVishal.blog.controllers;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codeWithVishal.blog.exceptions.ResourceNotFound;
import com.codeWithVishal.blog.payloads.UserDto;
//import com.codeWithVishal.blog.services.UserService;
import com.codeWithVishal.blog.services.impl.UserServiceImpl;

@RestController
@RequestMapping("/api/user")
public class UserController {
	@Autowired
	private UserServiceImpl userService;
	@PostMapping("/")
	public ResponseEntity<UserDto> createdUser(@RequestBody UserDto user) {
		UserDto createdUser=this.userService.createUser(user);
		return new ResponseEntity<>(createdUser,HttpStatus.CREATED);
	}
	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> updateUser(@RequestBody UserDto user,@PathVariable("userId") int id) throws ResourceNotFound {
		UserDto updateedUser=this.userService.updateUser(user,id);
		return new ResponseEntity<UserDto>(updateedUser,HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<UserDto> getUserById(@PathVariable("id") int id) throws ResourceNotFound {
		UserDto fetchedUser=this.userService.getUserById(id);
		return new ResponseEntity<UserDto>(fetchedUser,HttpStatus.FOUND);
	}
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAll() {
		List<UserDto> allUser=this.userService.getAllUser();
		return new ResponseEntity<>(allUser,HttpStatus.FOUND);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id) {
		 this.userService.deleteUser(id);
		return new ResponseEntity<>(null,HttpStatus.OK);
	}

}
