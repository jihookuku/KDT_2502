package kr.co.himedia.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import kr.co.himedia.dto.TodoDTO;
import kr.co.himedia.service.TodoService;
import kr.co.himedia.utils.JwtUtils;

@RestController
public class TodoController {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	Map<String, Object> result = null;
	@Autowired TodoService service;
	
	@PostMapping(value="/insert")
	public Map<String, Object> insert(@RequestBody Map<String, String> params,
			@RequestHeader Map<String, String> header){
		logger.info("params : "+params);
		result = new HashMap<String, Object>();
		boolean success = service.insert(params);
		result.put("success", success);
		return result;
	}
	
	@PostMapping(value="/list")
	public Map<String, Object> list(@RequestBody Map<String, String> params,
			@RequestHeader Map<String, String> header){
		logger.info("params : "+params);
		logger.info("header : {}",header);
		
		String token = header.get("authorization");
		Map<String, Object> payload = JwtUtils.readToken(token);
		String loginId = (String) payload.get("id");
		boolean login = false;		
		result = new HashMap<String, Object>();
		
		if(loginId != null && loginId.equals(params.get("id"))) {
			List<TodoDTO> list =service.list(params.get("id"));
			result.put("list", list);
			login = true;
		}
		
		result.put("loginYN", login);
				
		return result;
	}
	
	@PutMapping(value="/update")
	public Map<String, Object> update(@RequestBody TodoDTO dto,
			@RequestHeader Map<String, String> header){
		logger.info("params : "+dto.getIdx()+"/"+dto.isDone());
		result = new HashMap<String, Object>();
		boolean success = service.update(dto);
		result.put("success", success);
		return result;
	}
	
	@DeleteMapping(value="/del")
	public Map<String, Object> del(@RequestBody Map<String, String> params,
			@RequestHeader Map<String, String> header){
		logger.info("params : "+params);
		result = new HashMap<String, Object>();
		boolean success = service.del(params);
		result.put("success", success);
		return result;
	}

}
