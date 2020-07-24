package com.cos.blog.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.cos.blog.config.aop.RoleIntercepter;
import com.cos.blog.config.aop.SessionIntercepter;

// 필터링 
@Configuration
public class WebConfig implements WebMvcConfigurer{ // implements WebMvcConfigurer 하면 web.xml 파일됨
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		// 다른곳에서 사용 하지 않아서 굳이 IOC 할 필요 없음 
		
		registry.addInterceptor(new SessionIntercepter())
		.addPathPatterns("/user/**")
		.addPathPatterns("/post/**")
		.addPathPatterns("/post**");
		
		registry.addInterceptor(new RoleIntercepter()).addPathPatterns("/admin/**");
	}
}
