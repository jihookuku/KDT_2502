package kr.co.himedia.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.co.himedia.entity.Employee;
import kr.co.himedia.repo.EmployeeRepo;

@Service
public class JpaService {
	
	public JpaService(EmployeeRepo repo) {
		this.repo = repo;
	}
	
	final EmployeeRepo repo;
	

	public List<Employee> findByName(String name) {
		return repo.findByName(name);
	}

}
