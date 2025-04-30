package kr.co.himedia.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.himedia.dao.TodoDAO;
import kr.co.himedia.dto.TodoDTO;

@Service
public class TodoService {

Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired TodoDAO dao;
	
	public List<TodoDTO> list(String id) {
		return dao.list(id);
	}

	public boolean insert(Map<String, String> params) {
		int row = dao.insert(params);
		return row > 0;
	}

	public boolean del(Map<String, String> params) {
		int row = dao.del(params.get("idx"));
		return row > 0;
	}
	
	
	
	
	
}
