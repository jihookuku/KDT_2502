package kr.co.himedia.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.SecretKey;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@RestController
public class TokenController {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	private SecretKey pri_key = null; // 비밀키
	
	@GetMapping(value="/get_token")
	public String getToken() {
		
		// 내용
		Map<String, String> payload = new HashMap<String, String>();
		payload.put("id", "admin");
		payload.put("name", "김지훈");
		payload.put("role", "ADMIN");
		
		//서명할 키
		pri_key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
		
		// header.payload.Signature
		String token = Jwts.builder()
				.setHeaderParam("alg", "HS256") 	// 사용 알고리즘
				.setHeaderParam("typ", "JWT")		//토큰종류
				.setClaims(payload)		// 내용
				.setIssuedAt(new Date())	// 발급일자
				.setExpiration(new Date(System.currentTimeMillis()+(1000*60*30)))	//유효시간(30분)
				.signWith(pri_key) //서명할 키
				.compact();	// 생성	
		
		return token;
	}

}
