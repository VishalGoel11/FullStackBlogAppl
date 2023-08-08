package com.Blog.service;

import java.util.List;

import com.Blog.entities.User;
import com.Blog.payloads.UserDto;

public interface UserService {
	
	UserDto createUser(UserDto user);
	UserDto updateUser(UserDto user,int id);
	void deleteUser(int id);
	List<UserDto> getAllUser();
	UserDto getUserById(int id);
}
