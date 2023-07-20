package com.codeWithVishal.blog.services.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.codeWithVishal.blog.entity.Category;
import com.codeWithVishal.blog.entity.Post;
import com.codeWithVishal.blog.entity.User;
import com.codeWithVishal.blog.exceptions.ResourceNotFound;
import com.codeWithVishal.blog.payloads.PostDto;
import com.codeWithVishal.blog.payloads.UserDto;
import com.codeWithVishal.blog.repositories.CategoryRepo;
import com.codeWithVishal.blog.repositories.PostRepo;
import com.codeWithVishal.blog.repositories.UserRepo;
import com.codeWithVishal.blog.services.PostService;
@Service
public class PostServiceImpl implements PostService {
	@Autowired
	private PostRepo repo;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private CategoryRepo catRepo;
	@Autowired
	private UserRepo userRepo;
	@Override
	public PostDto createPost(PostDto postDto,int cat_Id,int user_Id)  {
		Post post=this.modelMapper.map(postDto, Post.class);
		User user=null;
		try {
			user = this.userRepo.findById(user_Id).orElseThrow(()->new ResourceNotFound("User", "userId",user_Id));
		} catch (ResourceNotFound e) {
			e.printStackTrace();
		}
		Category category=null;
		try {
			category = this.catRepo.findById(cat_Id).orElseThrow(()->new ResourceNotFound("Category", "catId",cat_Id));
		} catch (ResourceNotFound e) {
			e.printStackTrace();
		}
		post.setImgName("def.img");
		post.setAddedDate(new Date());
		post.setUser(user);
		post.setCategory(category);
		Post newpost=this.repo.save(post);
		PostDto newp=this.modelMapper.map(newpost, PostDto.class);
		return newp;
	}

	@Override
	public PostDto updatetePost(PostDto postDto, int id) throws ResourceNotFound {
		Post post=this.repo.findById(id).orElseThrow(()->new ResourceNotFound("post", "postid", id));
		post.setContent(postDto.getContent());
		post.setTitle(postDto.getTitle());
		Post update=this.repo.save(post);
		return this.modelMapper.map(update, PostDto.class);
	}

	@Override
	public PostDto deletePostById(int id) throws ResourceNotFound {
		Post post=this.repo.findById(id).orElseThrow(()->new ResourceNotFound("post", "postid", id));
		this.repo.delete(post);
		return this.modelMapper.map(post, PostDto.class);
	}

	@Override
	public List<PostDto> getAllPost() {
		List<Post> list=this.repo.findAll();
		return list.stream().map(post->this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		
	}

	@Override
	public PostDto getPostById(int id) {
		Post post=null;
		try {
			 post=this.repo.findById(id).orElseThrow(()->new ResourceNotFound("Post", "PostId", id));
		} catch (ResourceNotFound e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.modelMapper.map(post, PostDto.class);
	}

	@Override
	public List<PostDto> getPostByCategory(int id) throws ResourceNotFound {
		Category cat=this.catRepo.findById(id).orElseThrow(()->new ResourceNotFound("Category", "catId",id));
		List<Post> list=this.repo.findByCategory(cat);
		return list.stream().map(post-> this.modelMapper.map(post,PostDto.class)).collect(Collectors.toList());
	}

	@Override
	public List<PostDto> getPostByUser(int id) throws ResourceNotFound {
		User user=this.userRepo.findById(id).orElseThrow(()->new ResourceNotFound("Category", "catId",id));
		List<Post> list=this.repo.findByUser(user);
		return list.stream().map(post-> this.modelMapper.map(post,PostDto.class)).collect(Collectors.toList());
	}

	@Override
	public List<Post> searchPosts(String key) {
		return null;
	}
	
}
