package kr.co.himedia.repo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;

import kr.co.himedia.entity.Dept;
import kr.co.himedia.entity.Emp;
import kr.co.himedia.entity.QDept;
import kr.co.himedia.entity.QEmp;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository // 단독 클래스 일 경우 Repository 임을 알려야 등록이 된다.
public class JoinRepo {

	private final JPAQueryFactory factory;
	
	public JoinRepo(EntityManager em) {
		this.factory = new JPAQueryFactory(em);
	}
	
	//SELECT e.ename, d.deptname FROM emp e JOIN dept d ON e.deptno = d.deptno;
	public List<Emp> empJoinDept() {
		QDept d = QDept.dept;
		QEmp e = QEmp.emp;		
		// emp 와 dept 를 join 하는데 emp 에 있는 dept(e.dept.deptno) 를 기준으로 한다.
		// N+1 : 쿼리 로그를 보면 조인 후 deptno =1,2,4 에 대한 추출 쿼리를 실행 한다.
		// List<Emp> 에 담기 위해 개별 쿼리가 또 도는 것인데, 부모자식 간의 엔티티를 조회할 때 자주 일어난다.
		// return factory.selectFrom(e).from(e).join(e.dept, d).fetch();		
		return  factory.selectFrom(e).from(e).join(d).on(e.dept.deptno.eq(d.deptno)).fetch();	
	}
	
	//SELECT d.*, e.* FROM emp e RIGHT OUTER JOIN dept d ON e.deptno = d.deptno;
	public List<Map<String, Object>> empRightJoinDept() {
		QDept d = QDept.dept;
		QEmp e = QEmp.emp;
		
		List<Tuple> tuples = factory.select(d, e).from(e).rightJoin(d).on(e.dept.deptno.eq(d.deptno)).fetch();
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		Map<String, Object> map = null;
		
		for (Tuple t : tuples) {
			map = new HashMap<String, Object>();
			Emp emp = t.get(e);
			Dept dept = t.get(d);
			map.put("deptno", dept.getDeptno());
			map.put("deptname", dept.getDeptname());
			map.put("ename", emp == null ? "(null)" : emp.getEname());
			log.info("map : {}",map);
			list.add(map);
		}	
		return list;
		
	}
	
	

}











