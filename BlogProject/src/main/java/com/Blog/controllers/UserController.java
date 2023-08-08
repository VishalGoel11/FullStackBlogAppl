package com.Blog.controllers;

import java.util.List;
import java.util.Map;

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
import org.springframework.web.service.annotation.PutExchange;

import com.Blog.payloads.ApiResponse;
import com.Blog.payloads.UserDto;
import com.Blog.serviceImpl.UserServiceImpl;

@RestController
@RequestMapping("/api/users")
public class UserController {
	@Autowired
	private UserServiceImpl userService;
	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto userdto){
		UserDto user=this.userService.createUser(userdto);
		return new ResponseEntity<UserDto>(user,HttpStatus.CREATED);	
	}
	@PutMapping("/{id}")
	public ResponseEntity<UserDto> updateuser(@RequestBody UserDto userdto,@PathVariable("id") int id) {
		UserDto user=this.userService.updateUser(userdto, id);
		return new ResponseEntity<UserDto>(user,HttpStatus.OK);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse> deleteuser(@PathVariable int id){
		this.userService.deleteUser(id);
		return new ResponseEntity<ApiResponse>(new ApiResponse("user deleted succcessfully",true),HttpStatus.OK);		
	}
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAllUsers(){
		return new ResponseEntity<List<UserDto>>(this.userService.getAllUser(),HttpStatus.OK);
		}
	@GetMapping("/{id}")
	public ResponseEntity<UserDto> getUserById(
		@PathVariable	int id){
		return ResponseEntity.ok(this.userService.getUserById(id));
		}
	
}
