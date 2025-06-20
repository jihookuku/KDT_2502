package kr.co.himedia.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.himedia.entity.Emp;
import kr.co.himedia.service.JoinService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequiredArgsConstructor
public class JoinController {
	
	private final JoinService service;
	
	@GetMapping(value="/")
	public String home(){
		return "hello, home page!";
	}
	
	@GetMapping(value="/emp/join/dept")
	public List<Emp> empJoinDept(){
		return service.empJoinDept();
	}
	
	@GetMapping(value="/emp/right/dept")
	public List<Map<String, Object>> empRightJoinDept(){
		return service.empRightJoinDept();
	}
	
	@GetMapping(value="/fetchJoin")
	public List<Emp> fetchJoin(){
		return null;
	}
	
	

}
