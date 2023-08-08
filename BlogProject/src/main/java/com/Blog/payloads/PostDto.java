package com.Blog.payloads;

import java.util.Date;

import com.Blog.entities.Category;
import com.Blog.entities.User;

public class PostDto {
	private String title;
	private String content;
	private String imageName;
	private Date addedDate;
	private CatgeoryDto catdto;
	private UserDto userdto;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public Date getAddedDate() {
		return addedDate;
	}
	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}
	public CatgeoryDto getCatdto() {
		return catdto;
	}
	public void setCatdto(CatgeoryDto catdto) {
		this.catdto = catdto;
	}
	public UserDto getUserdto() {
		return userdto;
	}
	public void setUserdto(UserDto userdto) {
		this.userdto = userdto;
	}
	
}
