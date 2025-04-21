package kr.co.himedia.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TodoMapper {

	int insert(Map<String, String> params);

}
