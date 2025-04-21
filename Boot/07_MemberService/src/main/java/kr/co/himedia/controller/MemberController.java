package kr.co.himedia.controller;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.himedia.dto.MemberDTO;
import kr.co.himedia.service.MemberService;

@Controller
public class MemberController {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	// 여기에 객체 하나 만들어놨으니 그냥 이거 써라
	@Autowired MemberService service;
	
	@RequestMapping(value="/")
	public String main() {
		return "index";
	}
	
	// 모든 method 다 받겠다.
	@RequestMapping(value="/joinForm")
	public String joinForm() {
		return "joinForm";
	}
	
	//post 만 받겠다.
	@PostMapping(value="/join")
	public String join(Model model, 
			@RequestParam Map<String, String> param) {
		logger.info("회원가입 : {}",param);		
		String msg = service.join(param);
		model.addAttribute("msg", msg);		
		return "index";
	}
	
	// 클라이언트에서 보내오는 이름과 동일한 변수를 선언하면 받아온다.
	@PostMapping(value="/login")
	public String login(Model model, String id, String pw, HttpSession session) {		
		String page = "index";
		logger.info("login 요청 : {},{}",id,pw);
		boolean success = service.login(id,pw);
		logger.info("login 성공 여부 : "+success);
		if(success) {
			session.setAttribute("loginId", id);
			page = "redirect:/list";
		}else {
			model.addAttribute("msg", "아이디 또는 비밀번호를 확인해 주세요!");
		}				
		return page;
	}
	
	@RequestMapping(value="/list")
	public String list(Model model) {
		
		ArrayList<MemberDTO> list = service.list();
		model.addAttribute("list", list);
		return "main";
	}
	
	@RequestMapping(value="/del")
	public String del(String id) {
		logger.info("delete id : "+id);
		service.del(id);
		return "redirect:/list";
	}	
	
	@RequestMapping(value="/detail")
	public String detail(String id, Model model) {
		logger.info("detail : "+id);
		MemberDTO dto = service.detail(id);
		model.addAttribute("info", dto);
		return "detail";
	}

}


























