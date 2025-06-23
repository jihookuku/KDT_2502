package kr.co.himedia.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EncodeController {
	
	@Autowired PasswordEncoder encoder;
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	private String hash = "";
	
	@GetMapping(value="/")
	public String home() {
		return "Hello Home Page";
	}
	
	// 평문과 암화문의 패턴을 파악할수 없도록 같은 값을 넣어도 서로 다른 암호문이 출력되도록 한다.
	// 이때 추가되는 값을 sault 라고 한다.
	// 1234 -> 1234? -> 암호문
	@GetMapping(value="/encode/{msg}")
	public Map<String, String> encode(@PathVariable String msg) {
		
		hash = encoder.encode(msg);
		logger.info("hash : "+hash);
		Map<String, String> map = new HashMap<String, String>();
		map.put("plain", msg);
		map.put("encode", hash);
		
		return map;
	}
	
	// 암호문은 평문이 입력될때마다 달라지므로 직접 비교가 불가능 하다.
	// 평문 -> 암호화 -> 기존 함호문과 비교 이런식은 불가능하다.
	// 그래서 spring security 가 제공하는 메서드를 통해서만 비교해야 한다.
	@GetMapping(value="/match/{msg}")
	public Map<String, Object> match(@PathVariable String msg){		
		boolean success = encoder.matches(msg, hash);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("match", success);
		return map;
	}
	
	
	
	
	
	
	
	
	
	
	

}
