package com.codeWithVishal.blog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codeWithVishal.blog.entity.Post;
import com.codeWithVishal.blog.exceptions.ResourceNotFound;
import com.codeWithVishal.blog.payloads.PostDto;
import com.codeWithVishal.blog.repositories.CategoryRepo;
import com.codeWithVishal.blog.services.CategoryService;
import com.codeWithVishal.blog.services.PostService;
import com.codeWithVishal.blog.services.impl.PostServiceImpl;

@RestController
@RequestMapping("/api/")
public class PostController {
	@Autowired
	private PostServiceImpl service;
	
	@PostMapping("/user/{userId}/category/{categoryId}/posts")
	public ResponseEntity<PostDto> createPost1(@RequestBody PostDto postDto,@PathVariable int userId,@PathVariable int categoryId){
		PostDto createPost= this.service.createPost(postDto, categoryId, userId);	
		return new ResponseEntity<PostDto>(createPost,HttpStatus.CREATED);		
	}
	@GetMapping("/category/{catId}/posts")
	public ResponseEntity<List<PostDto>> getPostByCategory(@PathVariable int catId){
		List<PostDto> list=null;
		try {
		list=this.service.getPostByCategory(catId);
		} catch (ResourceNotFound e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<List<PostDto>>(list,HttpStatus.OK);
		
	}
	
	@GetMapping("/user/{userId}/posts")
	public ResponseEntity<List<PostDto>> getPostByUser(@PathVariable int userId){
		List<PostDto> list=null;
		try {
		list=this.service.getPostByUser(userId);
		} catch (ResourceNotFound e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<List<PostDto>>(list,HttpStatus.OK);
		
	}
	@GetMapping("/posts")
	public ResponseEntity<List<PostDto>> getAllPost(){
		List<PostDto> list=this.service.getAllPost();
		return new ResponseEntity<List<PostDto>>(list,HttpStatus.ACCEPTED);
	}
	@GetMapping("/posts/{id}")
	public ResponseEntity<PostDto> getPostById(@PathVariable int id){
		PostDto post=this.service.getPostById(id);
		return new ResponseEntity<PostDto>(post,HttpStatus.ACCEPTED);
	}
	@DeleteMapping("/posts/{id}")
	public ResponseEntity<PostDto> deletePost(@PathVariable int id){
		PostDto post=null;
		try {
			post = this.service.deletePostById(id);
		} catch (ResourceNotFound e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<PostDto>(post,HttpStatus.ACCEPTED);
	}
	@PutMapping("/posts/{id}")
	public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto,@PathVariable int id){
		PostDto post=null;
		try {
			post = this.service.updatetePost(postDto,id);
		} catch (ResourceNotFound e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<PostDto>(post,HttpStatus.OK);
	}
}
