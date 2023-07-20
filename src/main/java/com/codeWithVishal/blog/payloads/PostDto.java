package com.codeWithVishal.blog.payloads;

import java.util.Date;

import com.codeWithVishal.blog.entity.Category;
import com.codeWithVishal.blog.entity.User;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class PostDto {
	private	String title;
	private	String content;
	private	String imgName;
	private Date  addedDate;
	private CategoryDto category;
	private UserDto user;
}
