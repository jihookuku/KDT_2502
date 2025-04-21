package kr.co.himedia.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import kr.co.himedia.dto.BoardDTO;
import kr.co.himedia.dto.PhotoDTO;

@Mapper
public interface BoardDAO {

	ArrayList<BoardDTO> list();

	BoardDTO detail(String idx);

	int upHit(String idx);

	int del(String idx);

	int update(Map<String, String> param);

	int fileSave(String ori_filename, String new_filename, int idx);
	
	List<PhotoDTO> photos(String idx);

	int write(BoardDTO dto);

	List<String> getFiles(String idx);

	int delPhoto(String idx);


}



















