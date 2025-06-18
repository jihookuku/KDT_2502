package kr.co.himedia.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
	
	@Value("${prof.name}") private String name;
	@Value("${prof.db.username}") private String username;
	@Value("${prof.db.password}") private String password;
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@GetMapping(value="/")
	public Map<String, Object> home(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", name);
		map.put("id", username);
		map.put("pw", password);
		logger.info("map : {}",map);
		return map;
	}

	// 1. STS - 내장톰캣에서 실행 하는 방법
	// Run as > Aun configuration > SpringBoot 해당 프로젝트 선택
	// profile 란에 dev 라고 적고 실행
	
	// 2. STS - 외장톰캣 에서 실행 하는 방법
	// Servers 폴더의 catilina.proerties 에 다음 내용 추가
	// spring.profiles.active=dev
	
	// 3. 실제 톰캣에 배포
	// 톰캣의 conf 폴더의 catilina.proerties 에 다음 내용 추가
	// spring.profiles.active=dev
	
}















