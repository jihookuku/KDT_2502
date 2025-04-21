package kr.co.himedia.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.himedia.dto.BoardDTO;
import kr.co.himedia.service.ApiService;

@CrossOrigin
@RestController
public class ApiController {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired ApiService service;
	
	Map<String, Object> result = null;
	

	@GetMapping(value="/delete/{idx}")
	public Map<String, Object>delete(@PathVariable String idx){
		result = new HashMap<String, Object>();
		boolean success = service.delete(idx);
		result.put("idx", idx);
		result.put("success", success);
		return result;
	}
		
	@GetMapping(value="/detail/{idx}")
	public Map<String, Object>detail(@PathVariable String idx){
		result = new HashMap<String, Object>();
		BoardDTO dto = service.detail(idx);
		result.put("post", dto);
		return result;
	}
	
	@GetMapping(value="list/{page}")
	public Map<String, Object> list(@PathVariable String page){		
		return service.list(page);
	}
	
	
	@RequestMapping(value="/")
	public Map<String, Object> home(){
		result = new HashMap<String, Object>();
		result.put("msg", "Hello, Spring Boot Project!");
		return result;
	}
	
	
	/*
	POST http://localhost/write
	Content-Type: application/json

	{"user_name":"admin", "subject":"test subject", "content" : "test content"} 
	*/
	@PostMapping(value="/write")
	public Map<String, Object> write(@RequestBody BoardDTO dto){
		logger.info("user_name : "+dto.getUser_name());
		logger.info("subject : "+dto.getSubject());
		logger.info("content : "+dto.getContent());
		result = service.write(dto);
		logger.info("result : "+result);
		return result;
	}
	

	
	

}



































