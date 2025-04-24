package kr.co.himedia.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.himedia.dao.MemberDAO;

@Service
public class MemberService {
	@Autowired
	MemberDAO dao;

	public boolean login(Map<String, String> info) {
		int row = dao.login(info);
		return row > 0 ? true : false;
	}

}
