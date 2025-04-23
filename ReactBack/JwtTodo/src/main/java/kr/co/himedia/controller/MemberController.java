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

import kr.co.himedia.service.MemberService;
import kr.co.himedia.utils.JwtUtils;

@CrossOrigin
@RestController
public class MemberController {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	Map<String, Object> result = null;
	@Autowired MemberService service;
	
	@RequestMapping(value="/")
	public Map<String, Object> home(){
		result = new HashMap<String, Object>();
		result.put("msg", "Again To-Do List");
		return result;
	}
	
	@PostMapping(value="/join")
	public Map<String, Object> join(@RequestBody Map<String, String> params){
		logger.info("params : "+params);
		result = new HashMap<String, Object>();
		boolean success = service.join(params);
		result.put("success", success);
		return result;
	}
	
	@GetMapping(value="/overlay/{id}")
	public Map<String, Object> overlay(@PathVariable String id){
		logger.info(id+"체크");
		result = new HashMap<String, Object>();
		boolean success = service.overlay(id);
		result.put("use", success);
		return result;
	}
	
	@PostMapping(value="/login")
	public Map<String, Object> login(@RequestBody Map<String, String> params){
		logger.info("params : "+params);
		result = new HashMap<String, Object>();
		
		boolean success = service.login(params);
		if(success) {
			String token = JwtUtils.getToken("id", params.get("id"));
			result.put("token", token);
		}
		result.put("success", success);
		
		
		
		return result;
	}
	

}
