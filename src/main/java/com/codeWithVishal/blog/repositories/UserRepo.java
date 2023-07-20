package com.codeWithVishal.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.codeWithVishal.blog.entity.User;

public interface UserRepo extends JpaRepository<User, Integer>{

}
