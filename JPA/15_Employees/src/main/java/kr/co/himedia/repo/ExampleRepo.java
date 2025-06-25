package kr.co.himedia.repo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import org.hibernate.criterion.SubqueryExpression;
import org.springframework.stereotype.Repository;

import com.querydsl.core.Tuple;
import com.querydsl.core.types.SubQueryExpression;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;

import kr.co.himedia.entity.QDepartments;
import kr.co.himedia.entity.QDeptEmp;
import kr.co.himedia.entity.QDeptManager;
import kr.co.himedia.entity.QEmployees;
import kr.co.himedia.entity.QSalaries;
import kr.co.himedia.entity.QTitles;

@Repository
public class ExampleRepo {
	
	private final JPAQueryFactory factory;
	
	public ExampleRepo(EntityManager em) {
		this.factory = new JPAQueryFactory(em);
	}
	
	QEmployees e = QEmployees.employees;
	QTitles t = QTitles.titles;
	QDepartments d = QDepartments.departments;
	QDeptEmp de = QDeptEmp.deptEmp;
	QDeptManager dm = QDeptManager.deptManager;
	QSalaries s = QSalaries.salaries;
	
	/* 사원들의 이름(성과 이름을 합쳐서)과 입사일, 직책을 입사일이 빠른 순으로 보여주시오
	SELECT e.first_name, e.last_name, e.hire_date , t.title
	FROM employees e JOIN titles t ON e.emp_no = t.emp_no
		WHERE t.to_date = '9999-01-01' ORDER BY e.hire_date asc;
	*/
	public List<Map<String, Object>>exam1(){
		
		 List<Tuple> tuples = factory.select(e.firstName,e.lastName,e.hireDate,t.key.title).from(t).join(t.emp,e)
			.where(t.toDate.eq(LocalDate.of(9999, 1, 1))).orderBy(e.hireDate.asc()).fetch();
		 
		 List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		 Map<String, Object> map = null;
		 for (Tuple tuple : tuples) {
			map = new HashMap<String, Object>();
			map.put("name", tuple.get(e.firstName)+" ,"+tuple.get(e.lastName));
			map.put("hireDate", tuple.get(e.hireDate));
			map.put("title", tuple.get(t.key.title));
			list.add(map);
		}		 
		
		return list;
	}
		

	/*여러 팀을 거쳐간 사원의 이름을 가져 오시오
	SELECT 
		CONCAT(e.first_name,' ,',e.last_name) AS name
		,d.cnt
		FROM (select de.emp_no, COUNT(de.emp_no) AS cnt FROM dept_emp de 
			GROUP BY emp_no HAVING cnt > 1) d JOIN employees e ON d.emp_no = e.emp_no;
	*/	
	public List<String> exam2(){
		// JPA 는 FROM 절에 들어가는 서브쿼리를 처리하지 못한다.
		// 이런 경우는 먼저 FROM 절의 서브쿼리로 데이터를 추출 한다.
		List<Integer> subFrom = factory.select(de.emp.empNo).from(de)
			.groupBy(de.emp.empNo).having(de.dept.deptNo.count().gt(1)).fetch();
		
		// 이후 메인 쿼리에 활용하는 방법으로 사용해야 한다.(즉 서브쿼리 실행 후 결과물을 메인쿼리에 적용시키는 방향으로...)
		return factory.select(e.firstName.concat(e.lastName)).from(e).where(e.empNo.in(subFrom)).fetch();		
	}
	
	
	/* 그럼 각 인원이 어떤 팀에서 어떤 팀으로 이동했는지 알아보자
		select
			(select concat(e.first_name, e.last_name) from employees e where e.emp_no = de.emp_no)  as name
			,(select dept_name from departments d where d.dept_no = de.dept_no) as team
			,de.from_date 
			,de.to_date 
		from dept_emp de where de.emp_no in (
			select de.emp_no from dept_emp de group by emp_no having count(de.dept_no)>1)
		order by de.emp_no, de.from_date asc;
		473 msec
	*/	
	public List<Map<String, Object>> exam3(){
		
		SubQueryExpression<String> name = JPAExpressions.select(e.firstName.concat(e.lastName)).from(e).where(e.empNo.eq(de.emp.empNo));		
		SubQueryExpression<String> team = JPAExpressions.select(d.deptName).from(d).where(d.deptName.eq(de.dept.deptName));		
		SubQueryExpression<Integer> condition = JPAExpressions.select(de.emp.empNo).from(de).groupBy(de.emp.empNo)
				.having(de.dept.deptNo.count().gt(1));
		
		List<Tuple> tuples = factory.select(name,team,de.fromDate,de.toDate).from(de)
			.where(de.emp.empNo.in(condition)).orderBy(de.emp.empNo.asc(),de.fromDate.asc()).fetch();		
		
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		Map<String, Object> map = null;
		for (Tuple tuple : tuples) {
			map = new HashMap<String, Object>();
			map.put("name", tuple.get(name));
			map.put("team", tuple.get(team));
			map.put("fromDate", tuple.get(de.fromDate));
			map.put("toDate", tuple.get(de.toDate));
			list.add(map);
		}				
		return list;
	}
		
	
	/* 위 내용을 join 활용해서도 풀어보자!
	SELECT 
		concat(e.first_name,', ',e.last_name) AS name
		,d.dept_name as team
		,de.from_date
		,de.to_date
	FROM departments d RIGHT JOIN dept_emp de ON d.dept_no = de.dept_no
	JOIN employees e ON e.emp_no = de.emp_no
	WHERE de.emp_no in (
		SELECT de.emp_no FROM dept_emp de GROUP BY emp_no HAVING COUNT(de.dept_no)>1
	) ORDER BY de.emp_no, de.from_date;	
	*/
	public List<Map<String, Object>>exam4(){// 771 msec
		
		SubQueryExpression<Integer> condition = JPAExpressions.select(de.emp.empNo).from(de).groupBy(de.emp.empNo)
				.having(de.dept.deptNo.count().gt(1));
		
		List<Tuple> tuples = factory.select(
				e.firstName
				,e.lastName
				,d.deptName
				,de.fromDate
				,de.toDate
			).from(d).rightJoin(de).on(d.deptNo.eq(de.dept.deptNo))
			.join(e).on(e.empNo.eq(de.emp.empNo)).where(de.emp.empNo.in(condition))
			.orderBy(de.emp.empNo.asc()).orderBy(de.fromDate.asc()).fetch();
		
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		Map<String, Object> map = null;		
		for (Tuple tuple : tuples) {
			map = new HashMap<String, Object>();
			map.put("name", tuple.get(e.firstName)+", "+tuple.get(e.lastName));
			map.put("team", tuple.get(d.deptName));
			map.put("fromDate", tuple.get(de.fromDate));
			map.put("toDate", tuple.get(de.toDate));
			list.add(map);
		}			
		return list;
	}
	
	
		
	/* 현 팀장들의 이름, 성별, 입사일, 직책, 직책 기간
	select 	
		concat(e.first_name,', ',e.last_name) as name,
		e.gender,
		e.hire_date,
		dm.from_date,
		(select t.title from titles t where t.to_date = '9999-01-01' and t.emp_no = dm.emp_no) as title,
		dm.to_date
	from dept_manager dm join employees e on dm.emp_no = e.emp_no
	where to_date = '9999-01-01';		
	*/	
	public List<Map<String, Object>>exam5(){
		
		LocalDate target = LocalDate.of(9999, 1, 1);
		
		SubQueryExpression<String> title = JPAExpressions.select(t.key.title).from(t)
				.where(t.toDate.eq(target).and(t.emp.empNo.eq(dm.emp.empNo)));
		
		List<Tuple> tuples=factory.select(e.firstName,e.lastName,e.gender,dm.fromDate,dm.toDate,title)
			.from(dm).join(dm.emp,e).where(dm.toDate.eq(target)).fetch();
		
		List<Map<String, Object>>list = new ArrayList<Map<String,Object>>();
		Map<String, Object> map = null;
		for (Tuple tuple : tuples) {
			map = new HashMap<String, Object>();
			map.put("name",tuple.get(e.firstName)+", "+tuple.get(e.lastName));
			map.put("gender", tuple.get(e.gender));
			map.put("title", tuple.get(title));
			map.put("fromDate", tuple.get(dm.fromDate));
			map.put("toDate", tuple.get(dm.toDate));
			list.add(map);
		}				
		return list;
		
	}
		
		
	// 사원들의 사번, 이름, 현재 직책과 급여


}
















