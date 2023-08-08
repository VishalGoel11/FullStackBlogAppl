package com.Blog.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Blog.entities.Category;
import com.Blog.exceptions.ResourceNotFound;
import com.Blog.payloads.CatgeoryDto;
import com.Blog.repositories.CategoryRepo;
import com.Blog.service.CategoryService;
@Component
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryRepo repo;
	@Autowired
	private ModelMapper mapp;

	@Override
	public CatgeoryDto createCategory(CatgeoryDto catdto) {
		Category cat=this.mapp.map(catdto, Category.class);
		Category savedUser=this.repo.save(cat);
		return this.mapp.map(savedUser, CatgeoryDto.class);
	}

	@Override
	public CatgeoryDto updateCategory(CatgeoryDto catdto, int id) {
		Category cat=this.repo.findById(id).orElseThrow(()->new ResourceNotFound("Category","Id", id));
		cat.setCatDesc(catdto.getCatDesc());
		cat.setCatTitle(catdto.getCatTitle());
		Category update=this.repo.save(cat);
		return this.mapp.map(update, CatgeoryDto.class);		
	}

	@Override
	public CatgeoryDto getCategoryById(int id) {
		Category cat=this.repo.findById(id).orElseThrow(()->new ResourceNotFound("Category","Id", id));		
		return this.mapp.map(cat, CatgeoryDto.class);
	}

	@Override
	public void deleteCategory(int id) {
		Category cat=this.repo.findById(id).orElseThrow(()->new ResourceNotFound("Category","Id", id));		
		this.repo.delete(cat);
	}

	@Override
	public List<CatgeoryDto> getCategory() {
		List<Category> list=this.repo.findAll();
		List<CatgeoryDto> ans=list.stream().map((cat)->this.mapp.map(cat, CatgeoryDto.class)).collect(Collectors.toList());
		return ans;
	}

}
