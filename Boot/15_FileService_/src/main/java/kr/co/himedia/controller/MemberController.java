package kr.co.himedia.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.himedia.service.MemberService;

@Controller
public class MemberController {

	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired MemberService service;
	
	@RequestMapping(value="/")
	public String main() {
		return "index";
	}
	
	@RequestMapping(value="/join.go")
	public String joinForm() {
		return "joinForm";
	}
	
	@PostMapping(value="/join.do")
	public String join(Model model, @RequestParam Map<String, String>param) {
		logger.info("회원가입 : {}",param);
		String msg = service.join(param);
		model.addAttribute("msg", msg);
		return "index";
	}
	
	@GetMapping(value="/overlay.ajax")
	public @ResponseBody Map<String, Object> overlay(String id){
		logger.info("overlay check id : "+id);
		int cnt = service.overlay(id);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("cnt", cnt);
		return map;
	}
}
