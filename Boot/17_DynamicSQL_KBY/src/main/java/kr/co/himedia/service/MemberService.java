package kr.co.himedia.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.himedia.dao.MemberDAO;
import kr.co.himedia.dto.MemberDTO;
@Service
public class MemberService {

	Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	MemberDAO dao;

	public int join(MemberDTO dto) {
		int row = dao.join(dto);
		return row;
	}
	
	public MemberDTO datail(String id) {
		return dao.datail(id);
	}
	
	public boolean login(String id, String pw) {
		String loginId = dao.login(id, pw);
		return loginId == null ? false : true;
	}

	public ArrayList<MemberDTO> list(Map<String, String> param) {
		return dao.list(param);
	}

	public int update(Map<String, String> param) {
		return dao.update(param);
	}

	public List<MemberDTO> multi(List<String> userName) {		
		return dao.multi(userName);
	}

	public MemberDTO detail(String id) {
		return dao.detail(id);
	}

}


















