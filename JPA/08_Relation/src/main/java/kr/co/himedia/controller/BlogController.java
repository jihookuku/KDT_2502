package kr.co.himedia.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kr.co.himedia.entity.User;
import kr.co.himedia.service.BlogService;

@RestController
public class BlogController {
	
	@Autowired BlogService service;
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@PostMapping(value="/join")
	public User join(@RequestBody User user) {		
		logger.info(user.getId()+"/"+user.getName());				
		return service.join(user);
	}

}
