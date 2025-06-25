package kr.co.himedia.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReceiveController {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@GetMapping(value="/return/{msg}")
	public Map<String, Object> getReturn(@PathVariable String msg){
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("yourMsg", msg);				
		return map;
	}

}
