package kr.co.himedia.service;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.himedia.dao.MemberDAO;

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
	
}
