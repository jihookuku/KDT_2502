package kr.co.himedia.repo;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;

import kr.co.himedia.entity.Emp;
import kr.co.himedia.entity.QDept;
import kr.co.himedia.entity.QEmp;
import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class CustomRepo {	

	private final JPAQueryFactory factory;

	QEmp e = QEmp.emp;
	QDept d = QDept.dept;
		
	public CustomRepo(EntityManager em) {
		factory = new JPAQueryFactory(em);
	}

	public List<Emp> join(int offset, int limit) {		
		return factory.selectFrom(e).join(d).on(e.dept.deptno.eq(d.deptno))
				.offset(offset).limit(limit).fetch();		
	}

	/* fetchJoin 은 하이버네이트에서 모든 조인 데이터를 메모리에서 처리하려고 한다.
	 * 그래서 데이터가 많을 경우  offset/limit 의 처리가 원하는대로 되지 않거나 경고 로그가 발생할 수 있다.
	 *  그래서 인덱스가 걸려있는 pk 데이터를 가져와서 그 내용으로 fetchJoin 을 하면 정확성과 속도를 개선할 수 있다.
	 */
	public List<Emp> fetchJoin(int offset, int limit) {
		return factory.selectFrom(e).join(e.dept,d)
				.distinct().fetchJoin().limit(limit).offset(offset).fetch();
	}
	

	public List<Emp> fetchJoin2(int offset, int limit) {		
		// pk 인 empno 를 먼저 추출
		List<Integer> empnos = factory.select(e.empno).from(e).orderBy(e.empno.asc())
				.offset(offset).limit(limit).fetch();			
		
		// where 조건에 위에서 추출한 pk 정보를 넣음으로써 메모리에 올라갈 정보가 적어진다.
		// 쿼리는 2번 날리지만 불필요한 쿼리가 아니기에 문제되지 않는다.
		return  factory.selectFrom(e).join(e.dept,d)
				.distinct().fetchJoin().where(e.empno.in(empnos)).fetch();
	}
	
}









