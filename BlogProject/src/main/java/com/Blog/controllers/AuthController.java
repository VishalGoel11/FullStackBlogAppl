package com.Blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Blog.entities.JwtRequest;
import com.Blog.entities.JwtResponse;
import com.Blog.security.JwtTokenHelper;
import com.Blog.serviceImpl.CustomUserDetailsService;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
	
	@Autowired
	private JwtTokenHelper helper;
	@Autowired
	private CustomUserDetailsService userdetailservice;
	@Autowired
	private AuthenticationManager authManage;
	
	@PostMapping("/login")
	public ResponseEntity<JwtResponse> createToken(@RequestBody JwtRequest req){
		this.authenticate(req.getUsername(),req.getPassword());
		UserDetails loadUserByUsername = this.userdetailservice.loadUserByUsername(req.getUsername());
		String generateToken = this.helper.generateToken(loadUserByUsername);
		JwtResponse res=new JwtResponse();
		res.setUsername(generateToken);
		res.setUsername(loadUserByUsername.getUsername());
		return new ResponseEntity<JwtResponse>(res,HttpStatus.CREATED);		
	}
	private void authenticate(	String username, String password) {
		
		UsernamePasswordAuthenticationToken token=new UsernamePasswordAuthenticationToken(username, password);
		this.authManage.authenticate(token);
		
	}

}
