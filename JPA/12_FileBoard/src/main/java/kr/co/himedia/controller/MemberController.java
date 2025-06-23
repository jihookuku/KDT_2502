package kr.co.himedia.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.himedia.entity.Member;
import kr.co.himedia.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequiredArgsConstructor
public class MemberController {
	
	private final MemberService service;
	
	@GetMapping(value="/")
	public String home() {
		return "login";
	}
	
	@PostMapping(value="/login.do")
	public ModelAndView login(String id, String pw, 
			HttpSession session) {
		
		ModelAndView mav = new ModelAndView();		
		String page = "login";
		
		Member member = service.login(id,pw);
		if(member != null) {
			page="list";
			session.setAttribute("info", member);
		}else {
			mav.addObject("msg", "아이디 또는 비밀번호를 확인하세요");
		}
		
		mav.setViewName(page);
		
		return mav;
	}

}




















