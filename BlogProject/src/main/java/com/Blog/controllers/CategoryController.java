package com.Blog.controllers;

import java.util.List;

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

import com.Blog.payloads.ApiResponse;
import com.Blog.payloads.CatgeoryDto;
import com.Blog.serviceImpl.CategoryServiceImpl;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	@Autowired
	private CategoryServiceImpl impl;
	@PostMapping("/")
	public ResponseEntity<CatgeoryDto> createcategory(@RequestBody CatgeoryDto catdto){
		CatgeoryDto cat=this.impl.createCategory(catdto);
		return new ResponseEntity<CatgeoryDto>(cat,HttpStatus.CREATED);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse> deleteCatgeory(@PathVariable int id){
		this.impl.deleteCategory(id);
		return new ResponseEntity<ApiResponse>(new ApiResponse("success", false),HttpStatus.OK);
	}
	@PutMapping("/{id}")
	public ResponseEntity<CatgeoryDto> updateCategory(@RequestBody CatgeoryDto catdto,@PathVariable int id){
		CatgeoryDto cat=this.impl.updateCategory(catdto,id);
		return new ResponseEntity<CatgeoryDto>(cat,HttpStatus.OK);
	}
	@GetMapping("/")
	public ResponseEntity<List<CatgeoryDto>> getAll(){
		List<CatgeoryDto> cat=this.impl.getCategory();
		return new ResponseEntity<List<CatgeoryDto>>(cat,HttpStatus.OK);
	}
	@GetMapping("/{id}")
		public ResponseEntity<CatgeoryDto> getCategoryById(@PathVariable int id){
			CatgeoryDto cat=this.impl.getCategoryById(id);
			return new ResponseEntity<CatgeoryDto>(cat,HttpStatus.OK);
		}
}