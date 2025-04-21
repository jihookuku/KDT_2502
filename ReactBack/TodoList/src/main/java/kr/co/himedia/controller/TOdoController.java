package kr.co.himedia.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.co.himedia.dto.TodoDTO;
import kr.co.himedia.service.TodoService;

@RestController
public class TOdoController {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	 Map<String, Object> result = null;
	
	 @Autowired TodoService service;
	 
	// insert
	@PostMapping(value="/insert")
	public Map<String, Object> insert(@RequestBody Map<String, String> params){
		logger.info("params : {}",params);
		boolean success = service.insert(params);
		result = new HashMap<String, Object>();
		result.put("success", success);		
		return result;
	}
	
	// list
	@PostMapping(value="/list")
	public Map<String, Object> list(@RequestBody Map<String, String> params){
		logger.info("params : {} ",params);
		result = new HashMap<String, Object>();
		List<TodoDTO> list =service.list(params.get("id"));
		result.put("list", list);		
		return result;
	}
		
	// update
	@PutMapping(value="/update")
	public Map<String, Object> update(@RequestBody TodoDTO params){
		
		logger.info("params : "+params.getIdx()+"/"+params.isDone());
		result = new HashMap<String, Object>();
		boolean success = service.update(params);
		result.put("success", success);		
		return result;
	}
	
	
	
	
	
	
	// delete

}






