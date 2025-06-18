package kr.co.himedia.repo;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;

import kr.co.himedia.entity.Employee;
import kr.co.himedia.entity.QEmployee;

@Repository
public class EmployeeRepo {
	
	public EmployeeRepo(EntityManager em) {
		this.factory = new JPAQueryFactory(em);
	}
	
	final JPAQueryFactory factory;

	public List<Employee> findByName(String name) {
		// SELECT * FROM employee WHERE name = :name
		QEmployee emp = new QEmployee("emp");
		// selectFrom() : 해달 객체의 모든 필드를 가져올때		
		return factory.selectFrom(emp).where(emp.name.eq(name)).fetch();
	}

}














