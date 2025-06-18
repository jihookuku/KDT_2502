package kr.co.himedia.repo;

import org.springframework.data.repository.CrudRepository;

import kr.co.himedia.entity.Employee;

public interface EmployeeRepo extends CrudRepository<Employee, Integer> {
	
	// SELECT * FROM employee WHERE name = #{name}
	
	// SELECT * FROM employee WHERE age = #{age} ORDER BY no ASC
	
	// SELECT * FROM employee WHERE age = #{age} AND name = #{name}
	
	// SELECT * FROM employee WHERE name = #{name} AND email = #{email}
	
	// SELECT * FROM employee WHERE name = #{name} OR email = #{email} ORDER BY no DESC
	
	
	
	
	

}
