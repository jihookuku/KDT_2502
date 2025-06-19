package kr.co.himedia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.himedia.entity.Dept;
import kr.co.himedia.entity.Emp;
import kr.co.himedia.service.SearchService;

@RestController
public class SearchController {
	
	@Autowired SearchService service;
	
	// 1. han 의 근무 부서는?
	@GetMapping(value="/exam/1")
	public List<Dept> exam1() {
		return service.exam1();
	}
	
	// 2. 부서 위치가 LA 또는 BOSTON 인 부서에 속한 사람들의 정보
	@GetMapping(value="/exam/2")
	public List<Emp> exam2(){
		return service.exam2();
	}
	
	// 3. sales 부서에 근무하는 사원들의 정보
	@GetMapping(value="/exam/3")
	public List<Emp> exam3(){
		return service.exam3();
	}
	
	// 4. 직책(job) 이 manager 인 사원들(여러명일 경우 가장 빠른 직원 기준) 보다 입사일이 빠른 직원 정보
	@GetMapping(value="/exam/4")
	public List<Emp> exam4(){
		return service.exam4();
	}
	
	// 5. 부서별로 직원이 몇명인지 데이터 가져오기
	@GetMapping(value="/exam/5")
	public List<Dept> exam5(){
		return service.exam5();
	}

}
