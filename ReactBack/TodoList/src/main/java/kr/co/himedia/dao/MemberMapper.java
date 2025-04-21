package kr.co.himedia.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

	int overlay(String id);

	int join(Map<String, String> params);

	int login(Map<String, String> params);

}
