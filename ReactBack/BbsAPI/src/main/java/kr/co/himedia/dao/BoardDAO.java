package kr.co.himedia.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import kr.co.himedia.dto.BoardDTO;

@Mapper
public interface BoardDAO {

	int pages();

	ArrayList<BoardDTO> list(int offset);

	BoardDTO detail(String idx);

	int delete(String idx);

	int write(BoardDTO dto);

	int total(); // 페이지네이션

}





