package com.codeWithVishal.blog.services;

import java.util.List;

import com.codeWithVishal.blog.entity.Post;
import com.codeWithVishal.blog.exceptions.ResourceNotFound;
import com.codeWithVishal.blog.payloads.PostDto;

public interface PostService{
	PostDto createPost(PostDto postDto,int cat_Id,int post_id) throws ResourceNotFound;
	PostDto updatetePost(PostDto postDto,int id) throws ResourceNotFound;
	PostDto deletePostById(int id) throws ResourceNotFound;
	List<PostDto> getAllPost();
	PostDto getPostById(int id);
	List<PostDto> getPostByCategory(int id) throws ResourceNotFound;
	List<PostDto> getPostByUser(int id) throws ResourceNotFound;
	List<Post> searchPosts(String key);
}
