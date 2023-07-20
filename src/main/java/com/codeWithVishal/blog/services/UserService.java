package com.codeWithVishal.blog.services;

import java.util.List;

import com.codeWithVishal.blog.exceptions.ResourceNotFound;
import com.codeWithVishal.blog.payloads.UserDto;

public interface UserService {
	
	UserDto createUser(UserDto user);
	UserDto updateUser(UserDto user,int userId) throws ResourceNotFound;
	UserDto getUserById(int id) throws ResourceNotFound;
	List<UserDto> getAllUser();
	void deleteUser(int userId);
}
