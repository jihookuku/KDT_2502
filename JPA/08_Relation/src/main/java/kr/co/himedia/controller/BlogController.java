package kr.co.himedia.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kr.co.himedia.entity.Post;
import kr.co.himedia.entity.User;
import kr.co.himedia.service.BlogService;

@RestController
public class BlogController {
	
	@Autowired BlogService service;
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	//회원가입
	@PostMapping(value="/join")
	public User join(@RequestBody User user) {		
		logger.info(user.getId()+"/"+user.getName());				
		return service.join(user);
	}
	
	// 글쓰기
	@PostMapping(value="/write")
	public Post write(@RequestBody Map<String, String> param) {

		Post post = new Post();
		post.setTitle(param.get("title"));
		post.setContent(param.get("content"));
		
		// Post 의 userNo 는 User형태이므로 맞춰서 넣어줘야 한다.
		User user = new User();
		user.setUserNo(Long.parseLong(param.get("user_no")));		
		post.setUser(user);
		
		
		return service.write(post);
	}
	
	
	// 댓글쓰기
	
	//회원 리스트
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
