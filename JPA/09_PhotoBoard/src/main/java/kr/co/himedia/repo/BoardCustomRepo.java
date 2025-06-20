package kr.co.himedia.repo;

import java.util.List;

import kr.co.himedia.entity.Board;

public interface BoardCustomRepo {
	
	List<Board> searchListByPage(int offset,int pageForNum);
	

}
