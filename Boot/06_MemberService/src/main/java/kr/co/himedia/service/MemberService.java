package kr.co.himedia.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.himedia.dao.MemberDAO;
import kr.co.himedia.dto.MemberDTO;

public class MemberService {

	Logger logger = LoggerFactory.getLogger(getClass());

	public String join(String id, String pw, String name, int age, String gender, String email) {
		
		String msg = "회원 가입에 실패 했습니다.";		
		MemberDAO dao = new MemberDAO();		
		int row = dao.join(id,pw,name,age,gender,email);
		
		if(row>0) {
			msg = "회원 가입에 성공 했습니다.";
		}		
		return msg;
	}

	public String login(String id, String pw) {		
		MemberDAO dao = new MemberDAO();		
		return dao.login(id,pw);
	}
	
	public ArrayList<MemberDTO> list() {		
		MemberDAO dao = new MemberDAO();
		return dao.list();		
	}

	public MemberDTO detail(String id) {
		MemberDAO dao = new MemberDAO();
		return dao.detail(id);
	}

	public void del(String id) {
		MemberDAO dao = new MemberDAO();
		dao.del(id);		
	}
	
}



















