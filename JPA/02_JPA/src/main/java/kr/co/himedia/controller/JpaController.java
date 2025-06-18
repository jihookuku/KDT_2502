package kr.co.himedia.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JpaController {
	
	@GetMapping(value="/")
	public String home() {		
		return "{\"JPA UPDATE\":\"OK\"}";
	}

}
