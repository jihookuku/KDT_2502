package kr.co.himedia.repo;

import org.springframework.data.repository.CrudRepository;

import kr.co.himedia.entity.Employee;

public interface EmployeeRepo extends CrudRepository<Employee, Integer> {
	
	// JPQL - 메서드 이름이 기본제공 메서드와 같다 하더라도 @Query 가 붙으면 쿼리 내용을 따라간다.
	// 단점 - 실행 해봐야 오류 여부에 대해 알 수 있다.(Runtime)

}
