package kr.co.himedia.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.himedia.service.MainService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequiredArgsConstructor
public class MainController {
	
	private final MainService service;
	
	@GetMapping(value="/")
	public String home() {
		return "login";
	}
	
	
	@GetMapping(value="/{page}.go")
	public String move(@PathVariable String page) {
		return page;
	}
	
	@GetMapping(value="/overlay.do")
	public @ResponseBody Map<String, Object> overlay(String id){
		log.info("id="+id);
		Map<String, Object> map = new HashMap<String, Object>();
		boolean use = service.overlay(id);
		map.put("use", use);
		return map;
	}
	

}





