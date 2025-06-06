package kr.co.himedia.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import kr.co.himedia.dto.TodoDTO;
import kr.co.himedia.service.TodoService;
import kr.co.himedia.util.JwtUtils;

@CrossOrigin
@RestController
public class TodoController {

	Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired TodoService service;
	
	Map<String, Object> result = null;
	
	
	@PostMapping(value="/list")
	public Map<String, Object> list(
			@RequestBody Map<String, String> params,
			@RequestHeader Map<String, String> header){
		
		log.info("params : "+params);
		log.info("header : {}",header);
		
		result = new HashMap<String, Object>();
		boolean login = false;
				
		String token = header.get("authorization");
		Map<String, Object> payload = JwtUtils.readToken(token);
		String loginId = (String) payload.get("id");
		result = new HashMap<String, Object>();
		
		if (!loginId.equals("") && loginId.equals(params.get("id"))) {
			List<TodoDTO> list = service.list(params.get("id"));
			result.put("list", list);
			login = true;
		}
		result.put("loginYN", login);		
		
		return result;
	}
	

	@PostMapping(value="/insert")
	public Map<String, Object> insert(
			@RequestBody Map<String, String> params,
			@RequestHeader Map<String, String> header
			){
		log.info("params : "+params);
		log.info("header : {}",header);
		
		result = new HashMap<String, Object>();
		String token = header.get("authorization");
		Map<String, Object> payload = JwtUtils.readToken(token);
		String loginId = (String) payload.get("id");
		boolean login = false;
		
		if (loginId != null && loginId.equals(params.get("id"))) {
			boolean success = service.insert(params);
			result.put("success", success);
			login = true;
		}
		result.put("loginYN", login);
		
		return result;
	}
	
	@DeleteMapping(value="/del")
	public Map<String, Object> del(
			@RequestBody Map<String, String> params,
			@RequestHeader Map<String, String> header
			){
		log.info("params : "+params);
		log.info("header : "+header);
		result = new HashMap<String, Object>();
		boolean login = false;
		
		String token = header.get("authorization");
		Map<String, Object> payload = JwtUtils.readToken(token);
		String loginId = (String) payload.get("id");
		
		if (loginId != null && loginId.equals(params.get("id"))) {
			boolean success = service.del(params);
			result.put("success", success);
			login = true;
		}		
		result.put("loginYN", login);		
		return result;
	}
	
	@PutMapping(value="/toggle")
	public Map<String, Object> toggle(
			@RequestBody Map<String, String> params,
			@RequestHeader Map<String, String> header){
		
		log.info("params : {}",params);//id,idx,done
		log.info("header : {}",header);
		
		result = new HashMap<String, Object>();
		boolean login =  false;
		
		String token = header.get("authorization");
		Map<String, Object> payload = JwtUtils.readToken(token);
		String loginId = (String) payload.get("id");
		
		if (loginId != null && loginId.equals(params.get("id"))) {
			login = true;
			boolean success = service.toggle(params.get("idx"),params.get("done"));
			result.put("success", success);
		}
		
		result.put("loginYN", login);
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
