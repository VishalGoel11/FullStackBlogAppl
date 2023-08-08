package com.Blog.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFound extends RuntimeException{
	String resName;
	String fieldName;
	long value;
	public ResourceNotFound(String resName, String fieldName, int value) {
		super(String.format("%s not found %s : %s", resName,fieldName,value));
		this.resName = resName;
		this.fieldName = fieldName;
		this.value = value;
	}
}
