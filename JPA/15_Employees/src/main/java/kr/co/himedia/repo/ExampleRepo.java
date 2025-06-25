package kr.co.himedia.repo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.querydsl.core.Tuple;
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
	
	
	

	//여러 팀에 배정된 사원의 이름을 가져 오시오
		
	// 그럼 각 인원이 어떤 팀에서 어떤 팀으로 이동했는지 알아보자
		
	// 위 내용을 join 활용해서도 풀어보자!
		
	// 현 팀장들의 이름, 성별, 입사일, 직책, 직책 기간
		
	// 사원들의 사번, 이름, 현재 직책과 급여


}
