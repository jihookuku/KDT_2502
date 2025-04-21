package kr.co.himedia.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

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

import kr.co.himedia.dto.MemberDTO;
import kr.co.himedia.service.MemberService;

@Controller
public class MemberController {

	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	MemberService service;
	
	@GetMapping(value="/overlay.ajax")
	public @ResponseBody Map<String, Object>overlay(String id){
		
		logger.info("overlay check : "+id);
		int cnt = service.overlay(id);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("cnt", cnt);		
		return map;
	}
	
	
	@RequestMapping(value = "/")
	public String main() {
		return "index";
	}
	
	@RequestMapping(value = "/joinForm")
	public String joinForm() {
		return "joinForm";
	}
	
	@PostMapping(value = "/join")
	public String join(Model model, @RequestParam Map<String, String> param) {
		logger.info("회원가입 : {}", param);
		
		String msg = service.join(param);
		model.addAttribute("msg", msg);
		
		return "index";
	}
	
	@PostMapping(value = "/login")
	public String login(Model model, String id, String pw, HttpSession session) {
		
		String page = "index";
		logger.info("login 요청 : {},{}",id,pw);
		boolean success = service.login(id, pw);
		if (success) {
			session.setAttribute("loginId", id);
			page = "redirect:/list";
		}else {
			model.addAttribute("msg", "아이디 또는 비밀번호를 확인해 주세요!");
		}
		return page;
	}
	
	@RequestMapping(value = "/list") // 로그인 처리
	public String list(Model model, HttpSession session) {
		
		String page = "index";		
		String loginId = (String) session.getAttribute("loginId");
		
		if(loginId != null) {
			page = "main";
			ArrayList<MemberDTO> list = service.list();
			model.addAttribute("list", list);
		}else {
			model.addAttribute("msg", "로그인이 필요한 서비스 입니다.");
		}
		
		return page;
	}
	
	@RequestMapping(value = "/del") // 로그인 처리
	public String del(String id, HttpSession session, Model model) {
		String page = "index";
		String loginId = (String) session.getAttribute("loginId");		
		if(loginId != null) {
			logger.info("delete id : "+id);
			service.del(id);
			page = "redirect:/list";
		}else {
			model.addAttribute("msg", "로그인이 필요한 서비스 입니다.");
		}				
		return page;
	}
	
	@RequestMapping(value = "/detail") // 로그인 처리
	public String detail(String id, Model model, HttpSession session) {		
		String page = "index";
		String loginId = (String) session.getAttribute("loginId");		
		logger.info("detail : "+id);		
		if(loginId != null) {
			MemberDTO dto = service.detail(id);
			model.addAttribute("info", dto);
			page = "detail";			
		}else {
			model.addAttribute("msg", "로그인이 필요한 서비스 입니다.");
		}			
		return page;
	}
	
	// 수정상세보기 -  로그인 처리
	@RequestMapping(value = "/updateForm") // 로그인 처리
	public String updateForm(String id, Model model, HttpSession session) {
		String page = "index";
		String loginId = (String) session.getAttribute("loginId");	
		logger.info("updateForm : "+id);
		
		if(loginId != null) {
			MemberDTO dto = service.detail(id);
			model.addAttribute("info", dto);
			page = "updateForm";
		}else {
			model.addAttribute("msg", "로그인이 필요한 서비스 입니다.");
		}
		
		return page;
	}
	
	// 로그아웃
	@GetMapping(value="/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("loginId");
		return "redirect:/";
	}
	
	// 수정
	@PostMapping(value="/update")
	public String update(@RequestParam Map<String, String> param) {
		
		String id = param.get("id");
		String page = "redirect:/updateForm?id="+id;
		logger.info("params : {}",param);
		
		if(service.update(param) > 0) {
			page = "redirect:/detail?id="+id;
		}
		
		return page;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
