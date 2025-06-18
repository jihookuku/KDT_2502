package kr.co.himedia.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import kr.co.himedia.entity.Employee;

public interface EmployeeRepo extends CrudRepository<Employee, Integer> {
	
	// SELECT * FROM employee WHERE name = #{name}
	public List<Employee> findByName(String name);		
	
	// SELECT * FROM employee WHERE age = #{age} ORDER BY no ASC
	public List<Employee> findByAgeOrderByNoAsc(int age);
		
	// SELECT * FROM employee WHERE age = #{age} AND name = #{name}
	public List<Employee> findByAgeAndName(int age, String name);
		
	// SELECT * FROM employee WHERE name = #{name} AND email = #{email}
	public List<Employee> findByNameAndEmail(String name, String email);
	
	// SELECT * FROM employee WHERE name = #{name} OR email = #{email} ORDER BY no DESC
	public List<Employee> findByNameOrEmailOrderByNoDesc(String name, String email);
	
	
	
	

}
