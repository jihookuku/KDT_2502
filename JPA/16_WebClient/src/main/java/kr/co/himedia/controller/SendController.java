package kr.co.himedia.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

	// mono 방식은  1:1 의 동기 통신 상황에 적합
	// flux 방식은 1:n 의 비동기 통신상황에 적합
	@GetMapping(value="/get/flux")
	public List<HashMap<String, Object>> flux(){
		return service.flux();
	}
	

	

}
