package kr.co.himedia.repo.impl;

import java.util.List;

import javax.persistence.EntityManager;

import com.querydsl.core.types.SubQueryExpression;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;

import kr.co.himedia.entity.Dept;
import kr.co.himedia.entity.QDept;
import kr.co.himedia.entity.QEmp;
import kr.co.himedia.repo.DeptCustomRepo;

public class DeptCustomRepoImpl implements DeptCustomRepo {
	
	private final JPAQueryFactory factory;
	
	public DeptCustomRepoImpl(EntityManager em) {
		this.factory = new JPAQueryFactory(em);
	}

	@Override
	public List<Dept> findDeptByName(String name) {
		
		QEmp emp = QEmp.emp;
		QDept dept = QDept.dept;
		
		//sub query SubQueryExpression 이라는 객체로 반환 된다.
		SubQueryExpression<Integer> sub = JPAExpressions.select(emp.deptno).from(emp).where(emp.ename.eq(name));
		return factory.selectFrom(dept).where(dept.deptno.eq(sub)).fetch();
	}
	

}















