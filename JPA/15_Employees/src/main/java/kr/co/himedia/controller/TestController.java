package kr.co.himedia.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import kr.co.himedia.entity.Departments;
import kr.co.himedia.entity.DeptEmp;
import kr.co.himedia.entity.DeptManager;
import kr.co.himedia.entity.Employees;
import kr.co.himedia.entity.Salaries;
import kr.co.himedia.entity.Titles;
import kr.co.himedia.service.TestService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class TestController {
	
	// 각 테이블 연계가 잘 되는지 확인
	private final TestService service;
	
	@GetMapping(value="/emp/{limit}")
	public List<Employees> emp(@PathVariable int limit){		
		return service.emp(limit);
	}
	
	@GetMapping(value="/dept/{limit}")
	public List<Departments> dept(@PathVariable int limit){		
		return service.dept(limit);
	}
	
	@GetMapping(value="/title/{limit}")
	public List<Titles> title(@PathVariable int limit){		
		return service.title(limit);
	}
	
	@GetMapping(value="/salary/{limit}")
	public List<Salaries> salary(@PathVariable int limit){		
		return service.salary(limit);
	}
	
	@GetMapping(value="/dept_emp/{limit}")
	public List<DeptEmp> deptEmp(@PathVariable int limit){		
		return service.deptEmp(limit);
	}
	
	@GetMapping(value="/dept_manager/{limit}")
	public List<DeptManager> deptManager(@PathVariable int limit){		
		return service.deptManager(limit);
	}
	
}
















