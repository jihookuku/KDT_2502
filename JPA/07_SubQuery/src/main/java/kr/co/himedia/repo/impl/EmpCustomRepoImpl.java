package kr.co.himedia.repo.impl;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;

import com.querydsl.core.types.SubQueryExpression;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;

import kr.co.himedia.entity.Emp;
import kr.co.himedia.entity.QDept;
import kr.co.himedia.entity.QEmp;
import kr.co.himedia.repo.EmpCustomRepo;

public class EmpCustomRepoImpl implements EmpCustomRepo {

	private final JPAQueryFactory factory;
	
	public EmpCustomRepoImpl(EntityManager em) {
		this.factory = new JPAQueryFactory(em);
	}

	@Override
	public List<Emp> findAllByLoc(List<String> param) {		
		QDept dept = QDept.dept;
		QEmp emp = QEmp.emp;
		
		SubQueryExpression<Integer> sub = JPAExpressions.select(dept.deptno)
				.from(dept).where(dept.loc.in(param));
				
		return factory.selectFrom(emp).where(emp.deptno.in(sub)).fetch();
	}

	
	@Override
	public List<Emp> searchByDeptName(String deptname) {
		
		QDept dept = QDept.dept;
		QEmp emp = QEmp.emp;
		
		SubQueryExpression<Integer> sub = JPAExpressions.select(dept.deptno)
			.from(dept).where(dept.deptname.eq(deptname));
		
		return factory.selectFrom(emp).where(emp.deptno.in(sub)).fetch();

	}

	@Override
	public List<Emp> searchByJob(String job) {
		
		QEmp emp = QEmp.emp;
		
		SubQueryExpression<Date> sub = JPAExpressions.select(emp.hiredate.min())
			.from(emp).where(emp.job.eq(job));
		
		
		// lt(<), gt(>), loe(<=), goe(>=)
		return 	factory.selectFrom(emp).where(emp.hiredate.lt(sub))
				.orderBy(emp.hiredate.asc()).fetch();
	}
	
	
	
}









