package com.codeWithVishal.blog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codeWithVishal.blog.entity.Category;
import com.codeWithVishal.blog.entity.Post;
import com.codeWithVishal.blog.entity.User;
import com.codeWithVishal.blog.payloads.PostDto;

public interface PostRepo extends JpaRepository<Post, Integer>{
		
	List<Post> findByUser(User id);
	List<Post> findByCategory(Category cat);
}
