package kr.co.himedia.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
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
	
	
	@PostMapping(value="/list/return")
	public ArrayList<Map<String, String>> listReturn(int cnt, @RequestHeader Map<String, String> header){
		
		logger.info("cnt : "+cnt);
		logger.info("header : "+header);
		
		ArrayList<Map<String, String>> list = new ArrayList<Map<String,String>>();
		Map<String, String> map = null;
		for (int i = 0; i < cnt; i++) {
			map = new HashMap<String, String>();
			map.put("no", i+"");
			map.put("name", "kim");
			map.put("salary", (i*1000000)+"");
			list.add(map);
		}
				
		return list;
	}

}
