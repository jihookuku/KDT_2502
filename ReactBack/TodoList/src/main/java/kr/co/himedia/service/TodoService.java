package kr.co.himedia.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.himedia.dao.TodoMapper;
import kr.co.himedia.dto.TodoDTO;

@Service
public class TodoService {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired TodoMapper mapper;

	public boolean insert(Map<String, String> params) {
		int row = mapper.insert(params);
		return row>0;
	}

	public List<TodoDTO> list(String id) {
		return mapper.list(id);
	}

	public boolean update(TodoDTO params) {
		int row = mapper.update(params);
		return row>0;
	}
	
}
