package kr.co.himedia.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.SecretKey;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
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
	
	/* POST http://localhost:8080/read_token
	 * Content-Type: application/json
	 * authorization : {토큰값}
	 * 
	 * {바디내용}
	 */
	@PostMapping(value="/read_token")
	public Map<String, Object>readToken(@RequestHeader Map<String, String> header){
		
		logger.info("header : {}",header);
		// 보안과 관련된 토큰은 일반적으로 헤더를 통해 주고 받는다.
		String token = header.get("authorization");
		
		// 받아온 토큰을 비밀키를 이용해 파싱하는 과정
		Jws<Claims> claims = Jwts.parserBuilder().setSigningKey(pri_key).build().parseClaimsJws(token);
		
		// 원하는 payload 정보를 꺼내오기
		String id = claims.getBody().get("id", String.class);
		String name = (String) claims.getBody().get("name");
		String role = claims.getBody().get("role",String.class);
		Date expTime = claims.getBody().getExpiration();
		
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("id", id);
		result.put("name", name);
		result.put("role", role);
		result.put("expTime", expTime);		
		
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
