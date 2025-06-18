package kr.co.himedia.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.himedia.entity.Employee;
import kr.co.himedia.repo.EmployeeRepository;

@Service
public class CrudService {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired EmployeeRepository empRepo;
	
	public Employee saveOrUpdate(Employee emp) {
		// 데이터가 기존에 있으면 수정, 없으면 삽입(Upsert 와 비슷)
		return empRepo.save(emp);
	}
	
	public List<Employee> getAll() {
		
		List<Employee> list = new ArrayList<Employee>();
		
		for (Employee emp : empRepo.findAll()) {
			list.add(emp);
		}
		
		return list;
	}

}











