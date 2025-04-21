package kr.co.himedia.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
	
	// update
	
	// delete

}
