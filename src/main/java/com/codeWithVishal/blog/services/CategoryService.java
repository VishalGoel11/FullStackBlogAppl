package com.codeWithVishal.blog.services;

import java.util.List;

import com.codeWithVishal.blog.entity.Category;
import com.codeWithVishal.blog.exceptions.ResourceNotFound;
import com.codeWithVishal.blog.payloads.CategoryDto;

public interface CategoryService {
		
	CategoryDto create(Category cat);
	CategoryDto getCategoryById(int cat) throws ResourceNotFound;
	List<CategoryDto> getAll() throws ResourceNotFound;
	void delete(int id) throws ResourceNotFound;
	void deleteAll() throws ResourceNotFound;
	CategoryDto update(CategoryDto cat, int id) throws ResourceNotFound;
}
