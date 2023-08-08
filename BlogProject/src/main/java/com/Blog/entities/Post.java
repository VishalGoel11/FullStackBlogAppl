package com.Blog.entities;

import java.util.Date;

import com.Blog.payloads.CatgeoryDto;
import com.Blog.payloads.UserDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name="posts")
public class Post { 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int postId;
	@Column(name = "post_content",length = 10000,nullable = false)
	private String content;
	@Column(name = "post_title",length = 100,nullable = false)
	private String title;
	@Column(name="post_img")
	private String imageName;
	private Date addedDate;
	@ManyToOne
	private User userdto;
	@ManyToOne
	private Category catdto;
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public User getUserdto() {
		return userdto;
	}
	public void setUserdto(User userdto) {
		this.userdto = userdto;
	}
	public Category getCatdto() {
		return catdto;
	}
	public void setCatdto(Category catdto) {
		this.catdto = catdto;
	}
	

}
