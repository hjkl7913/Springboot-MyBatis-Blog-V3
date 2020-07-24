package com.cos.blog.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.blog.controller.dto.CommonRespDto;
import com.cos.blog.model.User;
import com.cos.blog.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/auth/joinProc")
	public @ResponseBody CommonRespDto<?> joinProc(@RequestBody User user) { //기본적으로 form 데이터만 받기 때문에 json으로 넘긴 값을 받을려면 @RequsetBody를 적어줌 => web.xml의 message converter를 오브젝트 메퍼로 바꿔줌(jackson)
		userService.회원가입(user);
		return new CommonRespDto<String>(1, "회원가입 성공");
	}
	
	@PostMapping("/auth/loginProc")
	public @ResponseBody CommonRespDto<?> loginProc(@RequestBody User user, HttpSession session){
		User persistUser = userService.로그인(user);
		
		if(ObjectUtils.isEmpty(persistUser)) {
			System.out.println("없음");
			return new CommonRespDto<String>(-1, "로그인 결과 실패");
		} else {
			System.out.println("있음");
			//세션등록 해야함
			session.setAttribute("principal", persistUser);
			return new CommonRespDto<String>(1, "로그인 결과 성공");	
		}
	}
}
