package kr.co.himedia.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

	int join(Map<String, String> params);

	int overlay(String id);

	int login(Map<String, String> params);

}
