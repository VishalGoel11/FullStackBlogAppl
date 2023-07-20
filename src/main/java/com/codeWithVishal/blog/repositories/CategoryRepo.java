package com.codeWithVishal.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codeWithVishal.blog.entity.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
