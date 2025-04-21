package kr.co.himedia.service;

import java.util.ArrayList;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.himedia.dao.MemberDAO;
import kr.co.himedia.dto.MemberDTO;

@Service
public class MemberService {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired MemberDAO dao;

	public String join(Map<String, String> param) {
		int row = dao.join(param);
		return row>0 ? "회원가입에 성공했습니다.":"회원가입에 실패했습니다.";
	}

	public boolean login(String id, String pw) {
		String loginId = dao.login(id,pw);
		return loginId == null?false : true;
	}

	public ArrayList<MemberDTO> list() {
		return dao.list();
	}

	public void del(String id) {
		int row = dao.del(id);
		logger.info("delete count : "+row);		
	}

	public MemberDTO detail(String id) {		
		return dao.detail(id);
	}

	public int update(Map<String, String> param) {
		return dao.update(param);
	}

	public int overlay(String id) {
		return dao.overlay(id);
	}	
	
}



















