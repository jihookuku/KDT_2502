package kr.co.himedia.repo;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;

import kr.co.himedia.entity.Emp;
import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class CustomRepo {	

	private final JPAQueryFactory factory;
	
	public CustomRepo(EntityManager em) {
		factory = new JPAQueryFactory(em);
	}

	public List<Emp> join(int offset, int limit) {
		return null;
	}

	public List<Emp> fetchJoin(int offset, int limit) {
		return null;
	}

	public List<Emp> fetchJoin2(int offset, int limit) {
		return null;
	}

}
