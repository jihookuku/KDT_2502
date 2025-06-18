package kr.co.himedia.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import kr.co.himedia.service.CustomService;

@RestController
public class CustomController {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired CustomService service;

}
