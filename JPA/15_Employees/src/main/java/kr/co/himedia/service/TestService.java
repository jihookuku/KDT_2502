package kr.co.himedia.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.co.himedia.entity.Departments;
import kr.co.himedia.entity.DeptEmp;
import kr.co.himedia.entity.DeptManager;
import kr.co.himedia.entity.Employees;
import kr.co.himedia.entity.Salaries;
import kr.co.himedia.entity.Titles;
import kr.co.himedia.repo.TableRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class TestService {
	
	private final TableRepo repo;

	public List<Employees> emp(int limit) {
		return repo.emp(limit);
	}

	public List<Departments> dept(int limit) {
		return repo.dept(limit);
	}

	public List<Titles> title(int limit) {
		return repo.title(limit);
	}

	public List<Salaries> salary(int limit) {
		return repo.salary(limit);
	}

	public List<DeptEmp> deptEmp(int limit) {
		return repo.deptEmp(limit);
	}

	public List<DeptManager> deptManager(int limit) {
			return repo.deptManager(limit);
	}

}
