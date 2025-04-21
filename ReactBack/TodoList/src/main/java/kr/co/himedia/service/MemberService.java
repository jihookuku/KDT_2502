package kr.co.himedia.service;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.himedia.dao.MemberMapper;

@Service
public class MemberService {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired MemberMapper mapper;

	public boolean overlay(String id) {		
		int cnt = mapper.overlay(id);
		return cnt == 0;
	}

	public boolean join(Map<String, String> params) {		
		int row = mapper.join(params);		
		return row>0;
	}

	public boolean login(Map<String, String> params) {
		int cnt = mapper.login(params);
		return cnt>0;
	}
	
}
















