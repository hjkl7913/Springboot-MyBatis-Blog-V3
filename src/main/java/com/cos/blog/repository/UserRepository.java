package com.cos.blog.repository;

import java.util.List;

import com.cos.blog.model.User;

public interface UserRepository {
	public List<User> findAll();
}
