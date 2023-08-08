package com.Blog.serviceImpl;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.Blog.exceptions.ResourceNotFound;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Blog.entities.User;
import com.Blog.payloads.UserDto;
import com.Blog.repositories.UserRepo;
import com.Blog.service.UserService;

import lombok.experimental.Tolerate;
@Component
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepo userrepo;
	@Autowired
	private ModelMapper modelmapper;
	@Override
	public UserDto createUser(UserDto userDto) {
		User user=this.modelmapper.map(userDto, User.class);
		User saved=userrepo.save(user);
		return this.modelmapper.map(saved, UserDto.class);
	}

	@Override
	public UserDto updateUser(UserDto userdto,int id) {
		User user=this.userrepo.findById(id).orElseThrow(()-> new ResourceNotFound("user", "id", id));
		User update= this.modelmapper.map(userdto, User.class);
		User updated=this.userrepo.save(update);
		return this.modelmapper.map(updated, UserDto.class);
	}

	@Override
	public void deleteUser(int id) {
		User user=this.userrepo.findById(id).orElseThrow(()-> new ResourceNotFound("user", "id", id));
		this.userrepo.delete(user);
		
	}

	@Override
	public List<UserDto> getAllUser() {
		List<User> list=this.userrepo.findAll();
		List<UserDto> actualList=list.stream().map((user)->this.modelmapper.map(user, UserDto.class)).collect(Collectors.toList());		
		return actualList;
	}

	@Override
	public UserDto getUserById(int id) {
		User user=this.userrepo.findById(id).orElseThrow(()-> new ResourceNotFound("user", "id", id));
		return this.modelmapper.map(user, UserDto.class);
	}

}
