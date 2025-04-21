package kr.co.himedia.dao;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import kr.co.himedia.dto.BoardDTO;

@Mapper
public interface BoardDAO {

	ArrayList<BoardDTO> list();

	int write(String subject, String user_name, String content);

	BoardDTO detail(String idx);

	int upHit(String idx);

	int del(String idx);

	int update(Map<String, String> param);
}










