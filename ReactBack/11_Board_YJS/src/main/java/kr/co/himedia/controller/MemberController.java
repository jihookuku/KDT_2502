package kr.co.himedia.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import kr.co.himedia.service.MemberService;
import kr.co.himedia.util.JwtUtils;

@RestController
@CrossOrigin
public class MemberController {
	@Autowired
	MemberService service;
	Map<String, Object> resp = null;
	public boolean login = false;
	Logger log = LoggerFactory.getLogger(getClass());

	@PostMapping(value = "/login")
	public Map<String, Object> login(@RequestBody Map<String, String> info) {
		resp = new HashMap<String, Object>();
		boolean success = service.login(info);
		// 로그인처리
		if(success) {
			String token = JwtUtils.getToken("id", info.get("id")); //요 id값을 id라는 이름으로 토큰을 발행한다
			resp.put("token", token);
			resp.put("success", success);
		}
		return resp;
	}

}
