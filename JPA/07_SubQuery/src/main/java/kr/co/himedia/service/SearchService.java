package kr.co.himedia.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.himedia.entity.Dept;
import kr.co.himedia.entity.Emp;
import kr.co.himedia.repo.DeptRepo;
import kr.co.himedia.repo.EmpRepo;

@Service
public class SearchService {

	@Autowired EmpRepo empRepo;
	@Autowired DeptRepo deptRepo;
		
	public List<Dept> exam1() {
		//select * from dept where deptno = (select deptno from emp where ename = 'han');
		/* 1. 서브쿼리를 사용하지 않는 방법(기본 메서드 사용)
		Emp emp = empRepo.findByEname("han");
		Dept dept = deptRepo.findById(emp.getDeptno()).get();				
		*/
		// 2. queryDSL 활용한 서브쿼리
		return deptRepo.findDeptByName("han");
	}

	public List<Emp> exam2() {
		// SELECT * FROM emp WHERE deptno IN
		// (SELECT deptno FROM dept WHERE loc IN('LA', 'boston'));
		List<String> params = new ArrayList<String>();
		params.add("LA");
		params.add("BOSTON");
		return empRepo.findAllByLoc(params);
	}

	public List<Emp> exam3() {
		// SELECT * FROM emp WHERE 
		// deptno=(SELECT deptno FROM dept WHERE deptname='sales');
		return empRepo.searchByDeptName("sales");
	}

	public List<Emp> exam4() {
		// SELECT * FROM emp WHERE hiredate < (SELECT MIN(hiredate) 
		// FROM emp WHERE job='manager') ORDER BY hiredate
		return null;
	}

	public List<Dept> exam5() {
		// SELECT d.deptname, 
		// (SELECT COUNT(deptno) FROM emp WHERE deptno = d.deptno) AS cnt 
		// FROM dept d;
		return null;
	}

}
