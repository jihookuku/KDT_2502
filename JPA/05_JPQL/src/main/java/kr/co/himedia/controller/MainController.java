package kr.co.himedia.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.co.himedia.entity.Employee;
import kr.co.himedia.service.MainService;

@RestController
public class MainController {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired MainService service;
	
	@GetMapping(value="/find/name")
	public List<Employee> findByName(String name){
		return service.getByName(name);
	}
	
	@GetMapping(value="/find/age/{age}")
	public List<Employee> findByAge(@PathVariable int age){
		return service.getByAge(age);
	}
	
	@GetMapping(value="/find/nameNemail")
	public List<Employee> findByNameAndEmail(String name, String email){
		return service.getByNameAndEmail(name, email);
	}
	
	@GetMapping(value="/find/names")
	public List<Employee> getNames(@RequestParam List<String> names){
		return service.getNames(names);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
