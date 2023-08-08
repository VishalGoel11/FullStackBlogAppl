package com.Blog.entities;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JwtRequest {
	
	private String email;
	private String password;
	public JwtRequest(String username, String password) {
		super();
		this.email = username;
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public JwtRequest() {}

	public String getUsername() {
		return email;
	}

	public void setUsername(String username) {
		this.email = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
