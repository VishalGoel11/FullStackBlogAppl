package com.codeWithVishal.blog.entity;

import java.util.Date;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
@Entity
@Table(name="Post")
@Getter
@Setter
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int postId;
	
	private String title;
	@Column(length = 10000)
	private String content;
	private String imgName="def.png";
	private Date addedDate;
	@ManyToOne
	private Category category;
	@ManyToOne
	private User user;

}
