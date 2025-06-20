package kr.co.himedia.repo.impl;

import java.util.List;

import javax.persistence.EntityManager;

import com.querydsl.jpa.impl.JPAQueryFactory;

import kr.co.himedia.entity.Board;
import kr.co.himedia.entity.QBoard;
import kr.co.himedia.repo.BoardCustomRepo;

public class BoardCustomRepoImpl 
	implements BoardCustomRepo {
	
	private final JPAQueryFactory factory;
	
	public  BoardCustomRepoImpl(EntityManager em) {
		this.factory = new JPAQueryFactory(em);
	}

	@Override
	public List<Board> searchListByPage(int offset, int pageForNum) {
		// SELECT * FROM bbs ORDER BY idx DESC OFFSET 0 LIMIT 20
		QBoard board = QBoard.board;		
		return factory.selectFrom(board).orderBy(board.idx.desc())
				.offset(offset).limit(pageForNum).fetch();
	}
	

}
