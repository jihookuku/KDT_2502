package kr.co.himedia.controller;

import java.util.ArrayList;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import kr.co.himedia.service.ApiService;

@RestController
public class SendController {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired ApiService service;
	
	@GetMapping(value="/get/send/{msg}")
	public Map<String, Object> getSend(@PathVariable String msg){
		logger.info("send param : "+msg);
		return service.getSend(msg);
	}
	
	//post  방식으로 보낼것이며, Header로 메시지를 전달할 예정이다.
	@GetMapping(value="/post/send/{cnt}")
	public ArrayList<Map<String, String>> 
		postSend(@PathVariable int cnt){
		logger.info("send param : "+cnt);
		return service.postSend(cnt);
	}
		
	@GetMapping(value="/get/flux")
	public Map<String, Object> flux(){
		return null;
	}
	
	

}
