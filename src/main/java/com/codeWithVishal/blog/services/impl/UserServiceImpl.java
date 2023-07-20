package com.codeWithVishal.blog.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeWithVishal.blog.entity.User;
import com.codeWithVishal.blog.exceptions.ResourceNotFound;
import com.codeWithVishal.blog.payloads.UserDto;
import com.codeWithVishal.blog.repositories.UserRepo;
import com.codeWithVishal.blog.services.UserService; 
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	@Override
	public UserDto createUser(UserDto user) {
		User user1=userDtoToUser(user);
		userRepo.save(user1);
		return userToUserDto(userRepo.save(user1));
	}

	@Override
	public UserDto updateUser(UserDto user1,int userId) throws ResourceNotFound {
		User userDto=this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFound("user","userId",userId));
		userDto.setEmail(user1.getEmail());
		userDto.setAbout(user1.getAbout());
		userDto.setName(user1.getName());
		userDto.setPassword(user1.getPassword());
		this.userRepo.save(userDto);
		return userToUserDto(userDto);
		
	}
	@Override
	public UserDto getUserById(int id) throws ResourceNotFound{
		User user1=this.userRepo.findById(id).orElseThrow(()-> new ResourceNotFound("user", "id", id));
		return userToUserDto(user1);
	}

	@Override
	public List<UserDto> getAllUser() {
		List<User> list=this.userRepo.findAll();
		List<UserDto> li=new ArrayList<>();
		for(int i=0;i<list.size();i++) {
			User user=list.get(i);
			li.add(userToUserDto(user));
		}
		return li;
	}

	@Override
	public void deleteUser(int userId) {
			this.userRepo.deleteById(userId);
	}
	private UserDto userToUserDto(User user) {
		UserDto userDto=new UserDto();
		userDto.setEmail(user.getEmail());
		userDto.setAbout(user.getAbout());
		userDto.setId(user.getId());
		userDto.setName(user.getName());
		userDto.setPassword(user.getPassword());
		return userDto;
	}

	private User userDtoToUser(UserDto user1) {
		User userDto=new User();
		userDto.setEmail(user1.getEmail());
		userDto.setAbout(user1.getAbout());
		userDto.setId(user1.getId());
		userDto.setName(user1.getName());
		userDto.setPassword(user1.getPassword());
		return userDto;
	}


}
