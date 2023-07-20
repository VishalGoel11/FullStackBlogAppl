package com.codeWithVishal.blog.exceptions;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.Getter;
import lombok.Setter;

public class ResourceNotFound extends Exception{
	 String resources;
     String fieldName;
     Integer fieldValue;
	public ResourceNotFound(String resourc,String fieldName,Integer i) {
		resources=resourc;
		this.fieldName=fieldName;
		fieldValue=i;
	}
	
	
}
