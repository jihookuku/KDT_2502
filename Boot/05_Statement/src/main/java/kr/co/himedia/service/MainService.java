package kr.co.himedia.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.himedia.dao.MainDAO;

public class MainService {
	
	Logger logger = LoggerFactory.getLogger(getClass());

	public boolean statement() {
		logger.info("table 만들기 요청 받음");		
		MainDAO dao = new MainDAO();	
		return dao.statement();	
	}

	public boolean preStatement() {
		logger.info("member 가입");
		MainDAO dao = new MainDAO();
		return dao.preStatement();
	}

	public void resultSet() {
		logger.info("회원 정보 보기");
		MainDAO dao = new MainDAO();
		dao.resultSet();
		
	}

}


















