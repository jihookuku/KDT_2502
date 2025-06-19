package kr.co.himedia.repo.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import com.querydsl.core.Tuple;
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

	@Override
	public List<Dept> searchAllDept() {
		QEmp emp = QEmp.emp;
		QDept dept = QDept.dept;
		
		SubQueryExpression<Long> cnt =JPAExpressions.select(emp.deptno.count()).from(emp)
			.where(emp.deptno.eq(dept.deptno));
		//List<Dept> : selectFrom() 처럼 전체 데이터를 가져올 경우
		//List<Tuple> : select() 처럼 일부 데이터를 가져올 경우
		List<Tuple> tuples = factory.select(dept.deptname,cnt).from(dept).fetch();
		
		List<Dept> list = new ArrayList<Dept>();
		Dept entity = null;
		for (Tuple t : tuples) {
			entity = new Dept();
			String deptname = t.get(dept.deptname);
			long count = t.get(cnt).longValue();
			entity.setDeptname(deptname);
			entity.setCnt(count);
			list.add(entity);
		}		
		return list;
	}
	

}















