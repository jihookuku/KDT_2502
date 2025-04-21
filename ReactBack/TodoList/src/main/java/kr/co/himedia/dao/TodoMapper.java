package kr.co.himedia.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import kr.co.himedia.dto.TodoDTO;

@Mapper
public interface TodoMapper {

	int insert(Map<String, String> params);

	List<TodoDTO> list(String id);

	int update(TodoDTO params);

}
