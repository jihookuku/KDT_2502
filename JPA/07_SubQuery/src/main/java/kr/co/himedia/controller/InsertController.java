package kr.co.himedia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.himedia.entity.Dept;
import kr.co.himedia.entity.Emp;
import kr.co.himedia.service.InsertService;

// 패키지 명이나 클래스명 등이 틀리면 난리날 수 있다.
@RestController
@RequestMapping("/insert")
public class InsertController {
	
	@Autowired InsertService service;
	
	// 기본 메서드 사용
	@PostMapping(value="/dept")
	public String insertDept(@RequestBody List<Dept> list) {				
		int row = service.insertDept(list);		
		return "{\"count \": "+row+"}";
	}
	
	// 기본 메서드 사용
	@PostMapping(value="/emp")
	public String insertEmp(@RequestBody List<Emp> list) {
		int row = service.insertEmp(list);
		return "{\"count \": "+row+"}";
	}

}











