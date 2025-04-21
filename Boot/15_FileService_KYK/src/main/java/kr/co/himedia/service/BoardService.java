package kr.co.himedia.service;

import java.util.ArrayList;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.himedia.dao.BoardDAO;
import kr.co.himedia.dto.BoardDTO;

@Service
public class BoardService {

	Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	BoardDAO dao;

	public ArrayList<BoardDTO> list() {
		return dao.list();
	}

	public void write(String subject, String user_name, String content) {
		int row = dao.write(subject,user_name,content);
		log.info("write row" +row);
	}

	public BoardDTO detail(String idx) {
		dao.upHit(idx); 
		return dao.detail(idx);

	}

	public int del(String idx) {
		return dao.del(idx);
	}

	public BoardDTO updateForm(String idx) {
		return dao.detail(idx);
	}

	public void update(Map<String, String> param) {
		int row = dao.update(param);
		log.info("updated row : "+row);
	}

	
}




















