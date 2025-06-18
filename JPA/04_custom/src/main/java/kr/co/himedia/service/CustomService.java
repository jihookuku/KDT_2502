package kr.co.himedia.service;

import java.util.ArrayList;
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
	
	//재귀함수 : 스스로를 호출하는 함수, 스스로가 실행되면서 정지 플래그가 없다면 무한루프로 인한 StackOverFlow 가 발생
	public List<Employee> findByNameAndEmail(String name, String email){
		return empRepo.findByNameAndEmail(name, email);
	}
	
	public List<Employee> findByNameOrEmailOrderByNoDesc(String name, String email){
		return empRepo.findByNameOrEmailOrderByNoDesc(name, email);
	}
	
	public List<Employee> saveAll(List<Employee> emps){		
		List<Employee> list = new ArrayList<Employee>();		
		Iterable<Employee> iter =empRepo.saveAll(emps);		
		for (Employee employee : iter) {
			list.add(employee);
		}				
		return list;
		
	}
	

}

















