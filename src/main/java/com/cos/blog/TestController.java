package com.cos.blog;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;

@Controller
public class TestController {

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/user")
	public @ResponseBody List<User> findAll() {
		List<User> users = userRepository.findAll();
		return users;
	}
	
	@GetMapping({"","/"})
	public String index() {
		return "index";
	}
}
