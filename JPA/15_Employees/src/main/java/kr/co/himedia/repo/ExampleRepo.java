package kr.co.himedia.repo;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class ExampleRepo {
	
	private final JPAQueryFactory factory;
	
	public ExampleRepo(EntityManager em) {
		this.factory = new JPAQueryFactory(em);
	}

}
