package kr.co.himedia.repo;

import org.springframework.data.repository.CrudRepository;

import kr.co.himedia.entity.Employee;

// Entity, Key 의 dataType
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
	// 기본 기능만 사용할 경우는 override 할 필요 없이 그냥 사용 하면 된다.	
}
