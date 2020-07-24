package com.cos.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;

// Controller, Repository, Configuration(설정파일), Service, Component(특징없이 메모리에 띄우고싶을때)
// RestController(데이터만 리턴), Bean

@Service // IOC
public class UserService { 
	
	@Autowired
	private UserRepository userRepository; // DI
	
	@Transactional
	public void 회원가입(User user) {
		// try catch로 처리 할필요없이 오류시에 fail 로 보내도됨
			user.setRole("ROLE_USER");
			userRepository.save(user);	
	}
	
	@Transactional(readOnly = true) //정합성 데이터변경을 허용하지않음 처음 트랙젝션이 시작됬을때 데이터를 유지 //select 할때 사용
	public User 로그인(User user) {
		// try catch로 처리 할필요없이 오류시에 fail 로 보내도됨
		
		return userRepository.login(user);
			
	}
	
	
}
