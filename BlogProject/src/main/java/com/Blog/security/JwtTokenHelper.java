package com.Blog.security;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenHelper {
	
	public static final long JWT_TOKEN_VALIDITY=5*60*60;
	private String secret="JwtTokenKey";
	
	public String getUserFromToken(String token) {
		return getClaimFromToken(token, Claims::getSubject);
	}
	
	public Date getExpirationFromToken(String token) {
		return getClaimFromToken(token, Claims::getExpiration);
	}
	
	public <T>T getClaimFromToken(String token, Function<Claims,T> claimResolver) {
		final Claims claim=getAllClaimFromToken(token);
		return claimResolver.apply(claim);
	}
	
	public Claims getAllClaimFromToken(String token) {
		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
	}
	public boolean isTokenExpired(String tooken) {
		Date date=getExpirationFromToken(tooken);
		return date.before(new Date());
	}
	public String generateToken(UserDetails user) {
		Map<String, Object> claims=new HashMap<>();
		return doGenerateToken(claims,user.getUsername());
	}

	public String doGenerateToken(Map<String, Object> claims, String username) {
		return Jwts.builder().setClaims(claims).setSubject(username).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
				.signWith(SignatureAlgorithm.HS512, secret).compact();
	}
	
	public boolean validateToken(String token,UserDetails user) {
		final String username=getUserFromToken(token);
		return (username.equals(user.getUsername())&& !isTokenExpired(token));
	}

}
