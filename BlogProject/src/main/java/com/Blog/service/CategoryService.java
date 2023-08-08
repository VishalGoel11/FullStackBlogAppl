package com.Blog.service;

import java.util.List;

import com.Blog.payloads.CatgeoryDto;

public interface CategoryService {
	
	CatgeoryDto createCategory(CatgeoryDto catdto);
	CatgeoryDto updateCategory(CatgeoryDto catdto,int id);
	CatgeoryDto getCategoryById(int id);
	void deleteCategory(int id);
	List<CatgeoryDto> getCategory();
}
