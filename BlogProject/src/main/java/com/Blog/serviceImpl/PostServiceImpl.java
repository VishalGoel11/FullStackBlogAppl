package com.Blog.serviceImpl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import com.Blog.entities.Category;
import com.Blog.entities.Post;
import com.Blog.entities.User;
import com.Blog.exceptions.ResourceNotFound;
import com.Blog.payloads.CatgeoryDto;
import com.Blog.payloads.PostDto;
import com.Blog.payloads.PostResponse;
import com.Blog.payloads.UserDto;
import com.Blog.repositories.CategoryRepo;
import com.Blog.repositories.PostRepo;
import com.Blog.repositories.UserRepo;
import com.Blog.service.PostService;
@Component
public class PostServiceImpl implements PostService{
	@Autowired
	private PostRepo postrepo;
	@Autowired
	private UserRepo userrepo;
	@Autowired
	private CategoryRepo catrepo;
	@Autowired
	private ModelMapper mapp;
	@Override
	public PostDto createPost(PostDto postdto,int userid,int catid) {		
		Category cat=this.catrepo.findById(catid).orElseThrow(()-> new ResourceNotFound("Category", "Id", catid));
		User user=this.userrepo.findById(userid).orElseThrow(()-> new ResourceNotFound("User", "Id", userid));
		Post post=this.mapp.map(postdto, Post.class);
		post.setImageName("def.png");
		post.setAddedDate(new Date());
		post.setUserdto(user);
		post.setCatdto(cat);
		Post saved=this.postrepo.save(post);
		return this.mapp.map(saved, PostDto.class);
	}

	

	@Override
	public void deletePost(int id) {
		this.postrepo.deleteById(id);
	}

	@Override
	public PostResponse getAllPost(int pagesize,int pagenumber,String sortby,String sortdir) {
		Sort sort=null;
		if(sortdir.equalsIgnoreCase("asc")) {
			sort=Sort.by(sortby).ascending();
		}else {
			Sort.by(sortby).descending();
		}
		Pageable p=PageRequest.of(pagenumber, pagesize,sort);
		Page<Post> pagepost=this.postrepo.findAll(p);
		List<Post> list=pagepost.getContent();
		List<PostDto> listans=list.stream().map((e)->this.mapp.map(e, PostDto.class)).collect(Collectors.toList());
		PostResponse post=new PostResponse();
		post.setContent(listans);
		post.setIslastpage(pagepost.isLast());
		post.setPagenumber(pagepost.getNumber());
		post.setToalpages(pagepost.getTotalPages());
		post.setTotalelements(pagepost.getTotalElements());
		post.setPagesize(pagepost.getSize());
		return post;
	}

	@Override
	public PostDto getPostById(int id) {
		Post post=this.postrepo.findById(id).orElseThrow(()-> new ResourceNotFound("post", "postid", id));
		PostDto postdto=this.mapp.map(post, PostDto.class);
		return postdto;
	}

	@Override
	public List<PostDto> getPostByCategory(int catId) {
		Category user=this.catrepo.findById(catId).orElseThrow(()->new ResourceNotFound("Post", "CategoryId", catId));
		List<Post> list=this.postrepo.findByCatdto(user);
		List<PostDto> ans=list.stream().map((e)->this.mapp.map(e, PostDto.class)).collect(Collectors.toList());
		return ans;
	}

	@Override
	public List<PostDto> getPostByUser(int userId) {
		User user=this.userrepo.findById(userId).orElseThrow(()->new ResourceNotFound("Post", "UserId", userId));
		List<Post> list=this.postrepo.findByUserdto(user);
		List<PostDto> ans=list.stream().map((e)->this.mapp.map(e, PostDto.class)).collect(Collectors.toList());
		return ans;
	}

	@Override
	public PostDto updatePost(PostDto postdto, int id) {
		Post post=this.postrepo.findById(id).orElseThrow(()->new ResourceNotFound("Post", "PostId", id));
		Post updatedpost=null;
		updatedpost.setPostId(id);
		updatedpost.setAddedDate(post.getAddedDate());
		updatedpost.setCatdto(post.getCatdto());
		updatedpost.setContent(post.getContent());
		updatedpost.setImageName(post.getImageName());
		updatedpost.setTitle(post.getTitle());
		updatedpost.setUserdto(post.getUserdto());
		updatedpost= this.mapp.map(postdto,Post.class);
		Post saved=this.postrepo.save(updatedpost);
		return this.mapp.map(saved, PostDto.class);
	}



	@Override
	public List<PostDto> searchPost(String keyord) {
		List<Post> list1=this.postrepo.findByContentContaining(keyord);
		List<PostDto> list=list1.stream().map((e)->this.mapp.map(e, PostDto.class)).collect(Collectors.toList());
		return list;
	}

}
