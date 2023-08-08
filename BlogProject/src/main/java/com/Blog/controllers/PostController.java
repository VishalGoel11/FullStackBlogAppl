package com.Blog.controllers;

import java.util.List;

import org.modelmapper.ModelMapper;
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

import com.Blog.entities.Post;
import com.Blog.payloads.ApiResponse;
import com.Blog.payloads.PostDto;
import com.Blog.payloads.PostResponse;
import com.Blog.serviceImpl.PostServiceImpl;

@RestController
@RequestMapping("/api")
public class PostController {
	@Autowired
	private PostServiceImpl impl;
	@PostMapping("/user/{userid}/category/{catid}/posts")
	public ResponseEntity<PostDto> createPost(@RequestBody PostDto postdto,@PathVariable int userid,@PathVariable int catid){
		PostDto post=this.impl.createPost(postdto, userid, catid);		
		return new ResponseEntity<PostDto>(post,HttpStatus.CREATED);
	}
	@GetMapping("/user/{userid}/posts")
	public ResponseEntity<List<PostDto>> getPostByUser(@PathVariable int userid){
		List<PostDto> post= this.impl.getPostByUser(userid);		
		return new ResponseEntity<List<PostDto>>(post,HttpStatus.OK);
	}
	@GetMapping("/category/{catid}/posts")
	public ResponseEntity<List<PostDto>> getPostByCategory(@PathVariable int catid){
		List<PostDto> post=this.impl.getPostByCategory(catid);		
		return new ResponseEntity<List<PostDto>>(post,HttpStatus.OK);
	}
	@PutMapping("/posts/{id}")
	public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postdto,@PathVariable int id){
		PostDto post=this.impl.updatePost(postdto,id);		
		return new ResponseEntity<PostDto>(post,HttpStatus.OK);
	}
	@DeleteMapping("/post/{id}")
	public ResponseEntity<ApiResponse> deletePost( @PathVariable int id){
		this.impl.deletePost(id);		
		return new ResponseEntity<ApiResponse>(new ApiResponse("Success", true),HttpStatus.OK);
	}
	@GetMapping("/posts")
	public ResponseEntity<PostResponse> getallpost(@RequestParam(value = "pagenumber",defaultValue = "1",required = false) int pagenumber,
			@RequestParam(value = "pagesize",defaultValue = "5",required = false) int pagesize,
			@RequestParam(value = "sortby", defaultValue = "postid",required = false) String sortby,
			@RequestParam(value = "sortdir", defaultValue = "asc",required = false) String sortdir){
		PostResponse post=this.impl.getAllPost(pagesize,pagenumber,sortby,sortdir);		
		return new ResponseEntity<PostResponse>(post,HttpStatus.OK);
	}
	@	GetMapping("/post/{postid}")
	public ResponseEntity<PostDto> getPostById(@PathVariable int postid){
		PostDto post=this.impl.getPostById(postid);		
		return new ResponseEntity<PostDto>(post,HttpStatus.OK);
	}
	@GetMapping("/posts/search/{keyword}")
	public ResponseEntity<List<PostDto>> searchPostByTitle(@PathVariable("keyword") String keyword){
		List<PostDto> list=this.impl.searchPost(keyword);
		return new ResponseEntity<List<PostDto>>(list,HttpStatus.OK);
	}
}
