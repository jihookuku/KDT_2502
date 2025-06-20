package kr.co.himedia.repo.impl;

import javax.persistence.EntityManager;

import com.querydsl.jpa.impl.JPAQueryFactory;

import kr.co.himedia.repo.BoardCustomRepo;

public class BoardCustomRepoImpl 
	implements BoardCustomRepo {
	
	private final JPAQueryFactory factory;
	
	public  BoardCustomRepoImpl(EntityManager em) {
		this.factory = new JPAQueryFactory(em);
	}
	

}
