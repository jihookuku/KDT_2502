package kr.co.himedia.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import kr.co.himedia.entity.Employee;
import kr.co.himedia.service.JpaService;

@RestController
public class JpaController {
	
	//@Autowired JpaService service; // 필드 주입
	
	// 생성자 주입
	public JpaController(JpaService service) {
		this.service = service;
	}
	
	final JpaService service;
	
	@GetMapping(value="/find/name")
	public List<Employee> getByName(String name){
		return service.findByName(name);
	}
	
	@GetMapping(value="/find/age/{age}")
	public List<Employee> getByAge(@PathVariable int age){
		return service.findByAge(age);
	}
	
	@GetMapping(value="/find/nameNemail")
	public List<Employee> getByNameAndEmail(String name, String email){
		return service.findByNameAndEmail(name,email);
	}

}

















