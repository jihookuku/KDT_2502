package kr.co.himedia.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.himedia.dao.MainDAO;

public class MainService {
	
	Logger logger = LoggerFactory.getLogger(getClass());

	public boolean dbConnect() {
		logger.info("서비스 접근");
		MainDAO dao = new MainDAO();
		boolean success = dao.dbConnect();
		logger.info("DAO 에서 받아온 값 : "+success);		
		return success;
	}

}
