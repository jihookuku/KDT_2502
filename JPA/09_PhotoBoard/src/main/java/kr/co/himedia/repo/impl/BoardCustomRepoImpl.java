package kr.co.himedia.repo.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import com.querydsl.core.Tuple;
import com.querydsl.core.types.SubQueryExpression;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;

import kr.co.himedia.dto.BoardDTO;
import kr.co.himedia.entity.Board;
import kr.co.himedia.entity.QBoard;
import kr.co.himedia.entity.QPhoto;
import kr.co.himedia.repo.BoardCustomRepo;

public class BoardCustomRepoImpl 
	implements BoardCustomRepo {
	
	private final JPAQueryFactory factory;
	
	public  BoardCustomRepoImpl(EntityManager em) {
		this.factory = new JPAQueryFactory(em);
	}

	// SELECT * FROM bbs ORDER BY idx DESC OFFSET 0 LIMIT 20
	// SELECT 
	//	idx,subject, user_name, reg_date, bHit 
	// (select count(file_idx) from photo idx = b.idx) as img
	// FROM bbs b ORDER BY idx DESC OFFSET 0 LIMIT 20
	@Override
	public List<BoardDTO> searchListByPage(int offset, int pageForNum) {
		
		QBoard board = QBoard.board;		
		QPhoto photo = QPhoto.photo;
		
		SubQueryExpression<Long> img = JPAExpressions.select(photo.fileIdx.count())
				.from(photo).where(board.idx.eq(photo.bbs.idx));
		
		//selectFrom() 은 Entity 형태로 반환 하지만 select() 는 Tuple 형태로 반환 한다.
		List<Tuple> tuples= factory.select(
				img,
				board.idx,
				board.subject,
				board.userName,
				board.reg_date,
				board.bHit
			).from(board).orderBy(board.idx.desc())
				.offset(offset).limit(pageForNum).fetch();
		
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		BoardDTO dto = null;
		for (Tuple t : tuples) {
			dto = new BoardDTO();
			dto.setImg(t.get(img).longValue());
			dto.setIdx(t.get(board.idx));
			dto.setSubject(t.get(board.subject));
			dto.setUserName(t.get(board.userName));
			dto.setContent(t.get(board.content));
			dto.setBHit(t.get(board.bHit));
			dto.setReg_date(t.get(board.reg_date));			
			list.add(dto);
		}			
		return list;
	}
	

}
