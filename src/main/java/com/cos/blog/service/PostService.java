package com.cos.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.blog.model.User;
import com.cos.blog.controller.dto.PostDetailRespDto;
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
	
	@Transactional(readOnly = true)
	public List<Post> 목록보기() {
		 return postRepository.findAll();
	}
	
	@Transactional(readOnly = true)
	public PostDetailRespDto 상세보기(int id) {
		 return postRepository.findById(id);
	}
	
	@Transactional
	public void 삭제하기(int id) {
		 postRepository.deleteById(id);
	}
	
	@Transactional
	public void 수정하기(Post post) {
		 postRepository.update(post);
	}
	
}
