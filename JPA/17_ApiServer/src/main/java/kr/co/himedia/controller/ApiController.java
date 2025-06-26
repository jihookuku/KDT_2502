package kr.co.himedia.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.himedia.service.ApiService;

@RestController
public class ApiController {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired ApiService service;
	
	@RequestMapping(value="/apiCall")
	public Map<String, Object> getList(String baseTime, String baseDate){
		logger.info("base Date : "+baseDate);
		logger.info("base Time : "+baseTime);
		return service.getList(baseTime, baseDate);
	}
	
	

}
