package com.codeWithVishal.blog.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeWithVishal.blog.entity.Category;
import com.codeWithVishal.blog.exceptions.ResourceNotFound;
import com.codeWithVishal.blog.payloads.CategoryDto;
import com.codeWithVishal.blog.repositories.CategoryRepo;
import com.codeWithVishal.blog.services.CategoryService;
@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryRepo repo;
	@Autowired
	private ModelMapper modelmapper;
	@Override
	public CategoryDto create(Category cat) {
		Category category= this.repo.save(cat);
		return this.modelmapper.map(category, CategoryDto.class);
	}

	@Override
	public CategoryDto update(CategoryDto cat, int id) throws ResourceNotFound {
		CategoryDto cat1=getCategoryById(id);
		cat1.setDesccription(cat.getDesccription());
		cat1.setName(cat.getName());
		return this.modelmapper.map(cat1, CategoryDto.class);
	}

	@Override
	public CategoryDto getCategoryById(int id) throws ResourceNotFound {
		Category catg=this.repo.findById(id).orElseThrow(()->new ResourceNotFound("Category","id", id));
		return this.modelmapper.map(catg, CategoryDto.class);
	}

	@Override
	public List<CategoryDto> getAll() throws ResourceNotFound {
		List<Category> list=this.repo.findAll();
		return list.stream().map((cat)->this.modelmapper.map(cat, CategoryDto.class)).collect(Collectors.toList());
		
	}

	@Override
	public void delete(int id) throws ResourceNotFound{
		this.repo.deleteById(id);
	}

	@Override
	public void deleteAll() throws ResourceNotFound{
		this.repo.deleteAll();
	}

}
