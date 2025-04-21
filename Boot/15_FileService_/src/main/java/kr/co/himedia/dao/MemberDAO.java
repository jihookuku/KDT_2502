package kr.co.himedia.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberDAO {

	int join(Map<String, String> param);

	int overlay(String id);

	
	
}
