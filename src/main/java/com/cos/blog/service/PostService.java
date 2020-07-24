package com.cos.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.blog.model.User;
import com.cos.blog.model.Post;
import com.cos.blog.repository.PostRepository;
import com.cos.blog.repository.UserRepository;

// Controller, Repository, Configuration(설정파일), Service, Component(특징없이 메모리에 띄우고싶을때)
// RestController(데이터만 리턴), Bean

@Service // IOC
public class PostService { 
	
	@Autowired
	private PostRepository postRepository; // DI
	
	@Transactional 
	public void 글쓰기(Post post) {
		 postRepository.save(post);
			
	}
	
	
}
