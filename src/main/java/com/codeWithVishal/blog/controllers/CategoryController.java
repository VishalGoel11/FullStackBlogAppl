package com.codeWithVishal.blog.controllers;

import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.RestController;

import com.codeWithVishal.blog.entity.Category;
import com.codeWithVishal.blog.exceptions.ResourceNotFound;
import com.codeWithVishal.blog.payloads.CategoryDto;
import com.codeWithVishal.blog.services.impl.CategoryServiceImpl;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
	@Autowired
	private CategoryServiceImpl catImpl;
	@PostMapping("/")
	public ResponseEntity<Category> create(@RequestBody Category cat){
		this.catImpl.create(cat);
		return new ResponseEntity<Category>(cat, HttpStatus.CREATED);
	}
	@PutMapping("/{id}")
	public ResponseEntity<CategoryDto> update(@RequestBody CategoryDto cat,@PathVariable("id") int id) throws ResourceNotFound{
		CategoryDto cat1=this.catImpl.update(cat,id);
		return new ResponseEntity<>(cat1, HttpStatus.ACCEPTED);
	}
	@GetMapping("/{id}")
	public ResponseEntity<CategoryDto> getCategoryById(@PathVariable("id") int id) throws ResourceNotFound{
		CategoryDto cat2=this.catImpl.getCategoryById(id);
		return new ResponseEntity<>(cat2, HttpStatus.FOUND);
	}
	@GetMapping("/")
	public ResponseEntity<List<CategoryDto>> getAll() throws ResourceNotFound{
		List<CategoryDto> list=this.catImpl.getAll();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	@DeleteMapping("/")
	public ResponseEntity<?> deleteAll() throws ResourceNotFound{
		this.catImpl.deleteAll();
		return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id) throws ResourceNotFound{
		this.catImpl.delete(id);
		return new ResponseEntity<>(null, HttpStatus.OK);
	}
}
