package kr.co.himedia.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

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
	
	public Employee getOne(String id) {
		Optional<Employee> opt = empRepo.findById(Integer.parseInt(id));
		//Optional 은 null 상황을 보호하기 위해 만들어진 객체
		//  null 일 경우를 처리 할 수 있도록 만들어졌다.
		//Employee emp = opt.get();
		
		// null 일 경우 특정 객체를 보낼수 있도록...
		//Employee emp = opt.orElse(new Employee());
		
		// 빈객체가 아닌 특정한 값을 넣어줄수 있다.
		/*
		Employee emp = opt.orElseGet(new Supplier<Employee>() {
			@Override
			public Employee get() {
				Employee employee = new Employee();
				employee.setNo(Integer.parseInt(id));
				employee.setName("없음");
				employee.setEmail("없음");
				employee.setContent(id+" 는 없는 번호 입니다.");				
				return employee;
			}			
		});
		*/
		// 람다식으로 간소화
		Employee emp = opt.orElseGet(() -> {
				Employee employee = new Employee();
				employee.setNo(Integer.parseInt(id));
				employee.setName("없음");
				employee.setEmail("없음");
				employee.setContent(id+" 는 없는 번호 입니다.");				
				return employee;						
		});
		
		return emp;	
		
	}

}











