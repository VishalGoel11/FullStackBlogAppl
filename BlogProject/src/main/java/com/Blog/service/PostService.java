package com.Blog.service;

import java.util.List;

import com.Blog.entities.Post;
import com.Blog.payloads.PostDto;
import com.Blog.payloads.PostResponse;

public interface PostService {
	PostDto createPost(PostDto postdto,int id1,int id2);
	PostDto updatePost(PostDto postdto,int id);
	void deletePost(int id);
	PostResponse getAllPost(int pagesize,int pagenumber,String sortby,String sortdir);
	PostDto getPostById(int id);
	List<PostDto> getPostByCategory(int catId);
	List<PostDto> getPostByUser(int userId);
	List<PostDto> searchPost(String keyord);
}
