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

	int del(String idx);

	int update(Map<String, String> param);

	int uphit(String idx);

	int write(BoardDTO dto);

	int fileSave(String ori_filename, String new_filename, int idx);

	List<PhotoDTO> photos(String idx);

	List<String> getFileName(String idx);

	int delFiles(String idx);

	PhotoDTO download(String idx);

}
