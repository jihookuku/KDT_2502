package kr.co.himedia.dao;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import kr.co.himedia.dto.BoardDTO;
import kr.co.himedia.dto.MemberDTO;

@Mapper
public interface MemberDAO {

	int join(Map<String, String> param);

	int overlay(String id);

	String login(String id, String pw);

	ArrayList<MemberDTO> list();

	int del(String id);

	MemberDTO detail(String id);
	
	ArrayList<BoardDTO> list1();

	int write(String subject, String user_name, String content);

	BoardDTO detail1(String idx);

	int upHit(String idx);

	int del1(String idx);
}

