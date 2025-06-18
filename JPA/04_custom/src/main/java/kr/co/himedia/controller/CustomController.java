package kr.co.himedia.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kr.co.himedia.entity.Employee;
import kr.co.himedia.service.CustomService;

@RestController
public class CustomController {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired CustomService service;
	
	@PostMapping(value="/input")
	public List<Employee> inputList(@RequestBody List<Employee> list){
		return service.saveAll(list);
	}
	
	@GetMapping(value="/find/name/{name}")
	public List<Employee> fineByName(@PathVariable String name){
		logger.info("name="+name);
		return service.findByName(name);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
