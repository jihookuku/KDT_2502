package kr.co.himedia.service;

import java.util.ArrayList;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.himedia.dao.MemberDAO;
import kr.co.himedia.dto.BoardDTO;
import kr.co.himedia.dto.MemberDTO;

@Service
public class MemberService {

	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired MemberDAO dao;

	public String join(Map<String, String> param) {
		int row = dao.join(param);
		return row>0 ? "회원가입에 성공했습니다." : "회원가입에 실패했습니다.";
	}

	public int overlay(String id) {
		return dao.overlay(id);
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


	public ArrayList<BoardDTO> list1() {
		return dao.list1();
	}

	public void write(String subject, String user_name, String content) {
		int row = dao.write(subject,user_name,content);
		logger.info("write row" +row);
	}

	public BoardDTO detail(String idx) {
		dao.upHit(idx); 
		return dao.detail1(idx);

	}

	public int del1(String idx) {
		return dao.del(idx);
	}

	public BoardDTO updateForm(String idx) {
		return dao.detail1(idx);
	}

	
	
	
}
