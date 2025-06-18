package kr.co.himedia.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.himedia.entity.Employee;
import kr.co.himedia.repo.EmployeeRepo;

@Service
public class MainService {
	
	Logger logger= LoggerFactory.getLogger(getClass());
	
	@Autowired EmployeeRepo empRepo;
	
	public List<Employee> getByName(String name){
		return empRepo.findByName(name);
	}
	
	public List<Employee> getByAge(int age){
		return empRepo.findByAge(age);
	}
	
	public List<Employee> getByNameAndEmail(String name, String email){
		return empRepo.findByEmailAndName(email, name);
	}
	
	public List<Employee> getNames(List<String> list){
		return empRepo.findByNames(list);
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
