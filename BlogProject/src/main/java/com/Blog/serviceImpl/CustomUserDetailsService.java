package com.Blog.serviceImpl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.Blog.exceptions.ResourceNotFound;
import com.Blog.repositories.UserRepo;

@Service
public class CustomUserDetailsService implements UserDetailsService {
@Autowired
private UserRepo rep;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		com.Blog.entities.User findByEmail = this.rep.findByEmail(username).orElseThrow(()->new ResourceNotFound(username, username, 0));
		System.out.println("vishal goel "+findByEmail.getEmail());
		return findByEmail;
		
	}

}