package kr.co.himedia.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.himedia.entity.Member;
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
	
	@PostMapping(value="/join.do")
	public String join(Member dto) {		
		String page = "join";		
		log.info(dto.getId());
		log.info(dto.getPw());
		log.info(dto.getName());		
		boolean success = service.join(dto);
		
		if(success) {
			page = "login";
		}
		
		return page;
	}
	
	@PostMapping(value="/login.do")
	public String login(Model model, String id, String pw, HttpSession session) {
		
		String page = "login";
		log.info(id+"/"+pw);
		boolean success = service.login(id,pw);
		if(success) {
			session.setAttribute("loginId", id);
			page = "list";
		}else {
			model.addAttribute("msg", "아이디 또는 비밀번호를 확인하세요!");
		}
		
		return page;
	}
	

}

























