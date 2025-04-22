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
import org.springframework.web.bind.annotation.RestController;

import kr.co.himedia.dto.TodoDTO;
import kr.co.himedia.service.TodoService;

@RestController
public class TodoController {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	Map<String, Object> result = null;
	@Autowired TodoService service;
	
	@PostMapping(value="/insert")
	public Map<String, Object> insert(@RequestBody Map<String, String> params){
		logger.info("params : "+params);
		result = new HashMap<String, Object>();
		boolean success = service.insert(params);
		result.put("success", success);
		return result;
	}
	
	@PostMapping(value="/list")
	public Map<String, Object> list(@RequestBody Map<String, String> params){
		logger.info("params : "+params);
		result = new HashMap<String, Object>();
		List<TodoDTO> list =service.list(params.get("id"));
		result.put("list", list);
		return result;
	}
	
	@PutMapping(value="/update")
	public Map<String, Object> update(@RequestBody TodoDTO dto){
		logger.info("params : "+dto.getIdx()+"/"+dto.isDone());
		result = new HashMap<String, Object>();
		boolean success = service.update(dto);
		result.put("success", success);
		return result;
	}
	
	@DeleteMapping(value="/del")
	public Map<String, Object> del(@RequestBody Map<String, String> params){
		logger.info("params : "+params);
		result = new HashMap<String, Object>();
		boolean success = service.del(params);
		result.put("success", success);
		return result;
	}

}
