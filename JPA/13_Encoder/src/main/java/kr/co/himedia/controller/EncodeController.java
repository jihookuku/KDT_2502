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
	
	@GetMapping(value="/encode/{msg}")
	public Map<String, String> encode(@PathVariable String msg) {
		
		hash = encoder.encode(msg);
		logger.info("hash : "+hash);
		Map<String, String> map = new HashMap<String, String>();
		map.put("plain", msg);
		map.put("encode", hash);
		
		return map;
	}

}
