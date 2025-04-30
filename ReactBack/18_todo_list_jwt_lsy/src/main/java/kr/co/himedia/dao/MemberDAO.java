package kr.co.himedia.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberDAO {

	int login(Map<String, String> info);

}
