package kr.co.himedia.repo;

import org.springframework.data.repository.CrudRepository;

import kr.co.himedia.entity.Employee;

public interface EmployeeRepo extends CrudRepository<Employee, Integer> {

}
