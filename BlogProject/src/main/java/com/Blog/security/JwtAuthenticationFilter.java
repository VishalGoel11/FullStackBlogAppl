package com.Blog.security;

import java.io.IOException;
import java.nio.charset.MalformedInputException;
import java.util.ArrayList;

import org.hibernate.validator.internal.util.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.Blog.repositories.UserRepo;
import com.Blog.serviceImpl.CustomUserDetailsService;

import org.slf4j.Logger;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter{
	
	@Autowired
	private UserRepo userrepo;
	
	@Autowired
	private CustomUserDetailsService userdetailservice;
	
	@Autowired
	private JwtTokenHelper jwttokenhelper;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String requestToken=request.getHeader("Authorization");
		System.out.println(requestToken);
		String username=null;
		String token=null;
		if(requestToken!=null && requestToken.startsWith("Bearer")) {
			token=requestToken.substring(7);
			try {
			username=this.jwttokenhelper.getUserFromToken(token);
			}catch (IllegalArgumentException e) {
				e.printStackTrace();
			}catch (ExpiredJwtException e) {
				e.printStackTrace();
			}catch (MalformedJwtException e) {
				e.printStackTrace();
			}catch(	BadCredentialsException e) {
				e.printStackTrace();
			}
		}else {
		}
		if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null) {
			UserDetails userdetail=this.userdetailservice.loadUserByUsername(username);
			if(this.jwttokenhelper.validateToken(token, userdetail)) {
				UsernamePasswordAuthenticationToken usernamepassword=new UsernamePasswordAuthenticationToken(userdetail,userdetail.getAuthorities());
				usernamepassword.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(usernamepassword);
				
			}else {
				System.out.println("Invalid Token");
			}
		}else {
			System.out.println("username is null or context");
		}
		filterChain.doFilter(request, response);
	}

}
