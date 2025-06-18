package kr.co.himedia.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.himedia.entity.Employee;
import kr.co.himedia.repo.EmployeeRepo;

@Service
public class CustomService {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired EmployeeRepo empRepo;
	
	public List<Employee> findByName(String name){
		return empRepo.findByName(name);
	}
	
	public List<Employee> findByAgeOrderByNoAsc(int age){
		return empRepo.findByAgeOrderByNoAsc(age);
	}
	
	public List<Employee> findByAgeAndName(int age, String name){
		return empRepo.findByAgeAndName(age, name);
	}
	
	public List<Employee> findByNameAndEmail(String name, String email){
		return findByNameAndEmail(name, email);
	}
	
	public List<Employee> findByNameOrEmailOrderByNoDesc(String name, String email){
		return findByNameOrEmailOrderByNoDesc(name, email);
	}
	
	

}

















