package kr.co.himedia.repo;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;

import kr.co.himedia.entity.Departments;
import kr.co.himedia.entity.DeptEmp;
import kr.co.himedia.entity.DeptManager;
import kr.co.himedia.entity.Employees;
import kr.co.himedia.entity.QDepartments;
import kr.co.himedia.entity.QDeptEmp;
import kr.co.himedia.entity.QDeptManager;
import kr.co.himedia.entity.QEmployees;
import kr.co.himedia.entity.QSalaries;
import kr.co.himedia.entity.QTitles;
import kr.co.himedia.entity.Salaries;
import kr.co.himedia.entity.Titles;
import lombok.extern.slf4j.Slf4j;

//JPA 의 기본 메서드를 사용하지 않고, queryDSL 만 사용하려고 인터페이스를 구현받지 않았다.
// JPA의 인터페이스를 구현받지 않으면 @Repository 어노테이션 추가 필요
@Repository
@Slf4j
public class TableRepo {
	
	private final JPAQueryFactory factory;
	
	public TableRepo(EntityManager em) {
		this.factory = new JPAQueryFactory(em);
	}

	public List<Employees> emp(int limit) {
		QEmployees e = QEmployees.employees;		
		return factory.selectFrom(e).limit(limit).fetch();
	}

	public List<Departments> dept(int limit) {
		QDepartments d = QDepartments.departments;		
		return factory.selectFrom(d).limit(limit).fetch();
	}

	public List<Titles> title(int limit) {	
		QTitles t = QTitles.titles;		
		return  factory.selectFrom(t).limit(limit).fetch();
	}

	public List<Salaries> salary(int limit) {
		QSalaries s = QSalaries.salaries;
		return  factory.selectFrom(s).limit(limit).fetch();
	}

	public List<DeptEmp> deptEmp(int limit) {
		QDeptEmp de = QDeptEmp.deptEmp;
		return factory.selectFrom(de).limit(limit).fetch();
	}

	public List<DeptManager> deptManager(int limit) {
		QDeptManager dm = QDeptManager.deptManager;
		return  factory.selectFrom(dm).limit(limit).fetch();
	}
	

}
