package kr.co.himedia.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import kr.co.himedia.entity.Employee;

public interface EmployeeRepo extends CrudRepository<Employee, Integer> {
	
	// JPQL - 메서드 이름이 기본제공 메서드와 같다 하더라도 @Query 가 붙으면 쿼리 내용을 따라간다.
	// 단점 - 실행 해봐야 오류 여부에 대해 알 수 있다.(Runtime)
	
	// 이름으로 Employee 의 모든 정보 가져오기
	// SELECT * FROM Employee WHERE name = ?
	@Query("SELECT e FROM Employee e WHERE e.name = ?1")
	public List<Employee> findByName(String name);
	
	// 나이로 Employee 의 모든 정보를 no 기준으로 오름차순 정렬 하여 가져오기
	// SELECT * FROM Employee WHERE age = ? ORDER BY no ASC
	@Query("SELECT e FROM Employee e WHERE e.age = :age ORDER BY e.no ASC")
	public List<Employee> findByAge(@Param("age") int age);
	
	// 이름과 이메일 모두 일치하는 Employee 의 모든 정보 가져오기
	// SELECT * FROM Employee WHERE email = ? AND name= ? 
	// 순수 쿼리를 사용 하고 싶을 경우
	@Query(value="SELECT * FROM Employee WHERE email = :email AND name= :name", nativeQuery=true)
	public List<Employee> findByEmailAndName(@Param("email") String email, @Param("name") String name);
	
	// 이름이 "KIM", "LEE","GANG" 인 사람의 Employee 정보를 name 기준으로 오름차순 정렬하여 가져오기
	// SELECT * FROM Employee WHERE name IN('KIM','LEE','GANG') ORDER BY name
	// 컬렉션 프레임 워크 활용
	@Query("SELECT * FROM Employee WHERE name IN :names ORDER BY name")
	public List<Employee> findByNames(@Param("names") List<String> list);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
