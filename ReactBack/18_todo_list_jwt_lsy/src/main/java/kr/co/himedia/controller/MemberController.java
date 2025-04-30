package kr.co.himedia.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kr.co.himedia.service.MemberService;
import kr.co.himedia.util.JwtUtils;

@CrossOrigin
@RestController
public class MemberController {
	
	Logger log = LoggerFactory.getLogger(getClass());
	
	Map<String, Object> result = null;
	
	@Autowired MemberService service;

	@PostMapping(value="/login")
	public Map<String, Object> login(@RequestBody Map<String, String> info){
		
		result = new HashMap<String, Object>();
		boolean success = service.login(info);
		
		if (success) {
			String token = JwtUtils.setToken("id", info.get("id"));
			result.put("token", token);
			result.put("success", success);
		}
		return result;
	}

}
