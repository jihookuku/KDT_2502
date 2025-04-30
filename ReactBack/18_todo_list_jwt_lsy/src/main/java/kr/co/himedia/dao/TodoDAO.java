package kr.co.himedia.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import kr.co.himedia.dto.TodoDTO;

@Mapper
public interface TodoDAO {

	List<TodoDTO> list(String id);

	int insert(Map<String, String> params);

	int del(String string);

}
