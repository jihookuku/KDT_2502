package kr.co.himedia.repo;

import java.util.List;

import kr.co.himedia.dto.BoardDTO;

public interface BoardCustomRepo {
	
	List<BoardDTO> searchListByPage(int offset,int pageForNum);
	

}
