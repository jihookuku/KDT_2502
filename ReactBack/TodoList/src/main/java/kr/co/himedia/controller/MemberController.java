package kr.co.himedia.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

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

@CrossOrigin
@RestController
public class MemberController {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	Map<String, Object> result = null;
	
	@Autowired MemberService service;
	
	@RequestMapping(value="/")
	public Map<String, Object> home(){
		result = new HashMap<String, Object>();
		result.put("msg", "Hello, TO-DO List");
		return result;
	}
	
	// 중복체크
	@GetMapping(value="/overlay/{id}")
	public Map<String, Object>overlay(@PathVariable String id){
		logger.info(id+"중복 체크");
		result = new HashMap<String, Object>();
		boolean success = service.overlay(id);
		result.put("use", success);		
		return result;
	}
		
	// 회원가입
	@PostMapping(value="/join")
	public Map<String, Object>join(
			@RequestBody Map<String, String> params){
		logger.info("회원가입 : "+params);
		result = new HashMap<String, Object>();
		boolean success = service.join(params);		
		result.put("success", success);
		return result;
	}
	
	// 로그인
	@PostMapping(value="/login")
	public Map<String, Object> login(
			@RequestBody Map<String, String> params, 
			HttpSession session){
		logger.info("param : {}",params);
		logger.info("session ID : "+session.getId());
		result = new HashMap<String, Object>();		
		boolean success = service.login(params);
		result.put("success", success);
		return result;
	}
	
	
	
	

}











