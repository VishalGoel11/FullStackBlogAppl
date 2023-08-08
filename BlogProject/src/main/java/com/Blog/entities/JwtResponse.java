package com.Blog.entities;

import org.springframework.context.annotation.Configuration;

import lombok.Builder;

@Configuration
@Builder
public class JwtResponse {

	private String jwtToken;
	private String username;
	public JwtResponse(String jwtToken, String username) {
		super();
		this.jwtToken = jwtToken;
		this.username = username;
	}
	public JwtResponse() {}
	public String getJwtToken() {
		return jwtToken;
	}
	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
}
