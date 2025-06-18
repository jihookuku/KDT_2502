package kr.co.himedia.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kr.co.himedia.entity.Employee;
import kr.co.himedia.service.CrudService;

@RestController
public class CrudController {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired CrudService service;
	
	
	@PostMapping(value="/input")
	public Employee input(@RequestBody Employee emp) {
		return service.saveOrUpdate(emp);
	}
	
	@GetMapping(value="/get")
	public List<Employee> getAll() {
		return service.getAll();
	}
	
	@GetMapping(value="/get/{id}")	
	public Employee getOne(@PathVariable String id) {
		return service.getOne(id);
	}
	
	@DeleteMapping(value="/del/{id}")
	public String del(@PathVariable String id) {
		service.del(id);		
		return "{\"msg\":\""+id+"번 데이터를 삭제 했습니다.\"}";
	}
	
	@PutMapping(value="/update")
	public Employee update(@RequestBody Employee emp) {
		return service.saveOrUpdate(emp);
	}
	
	

}
