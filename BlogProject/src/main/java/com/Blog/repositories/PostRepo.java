package com.Blog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Blog.entities.Category;
import com.Blog.entities.Post;
import com.Blog.entities.User;
import com.Blog.payloads.PostDto;
import com.Blog.payloads.UserDto;

public interface PostRepo extends JpaRepository<Post,Integer>{
	
	List<Post> findByUserdto(User userdto);
	List<Post> findByCatdto(Category category);
	List<Post> findByContentContaining(String title);
}
