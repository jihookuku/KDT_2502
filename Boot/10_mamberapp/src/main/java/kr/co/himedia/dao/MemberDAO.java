package kr.co.himedia.dao;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import kr.co.himedia.dto.MemberDTO;

@Mapper
public interface MemberDAO {

	int join(Map<String, String> param);

	String login(String id, String pw);

	ArrayList<MemberDTO> list();

	int del(String id);

	MemberDTO detail(String id);

	int update(Map<String, String> param);

	int overlay(String id);

}
