package kr.co.himedia.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.himedia.dto.MemberDTO;
import kr.co.himedia.service.MemberService;

@Controller
public class MemberController {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@RequestMapping(value="/")
	public String home() {
		return "index";
	}
	
	@RequestMapping(value="/joinForm")
	public String joinForm() {
		return "joinForm";
	}
	
	// 405 는 보내는 메서드와 받는 메서드가 일치하지 않을경우
	// client : GET -> server : POST 일 경우 등...
	@RequestMapping(value="/join", method = RequestMethod.POST)
	public String join(Model model, HttpServletRequest req) {		
		
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String gender = req.getParameter("gender");
		int age = Integer.parseInt(req.getParameter("age"));
		logger.info(id+" / "+pw+" / "+name+" / "+email+" / "+gender+" / "+age);
		
		MemberService service = new MemberService();
		String msg = service.join(id,pw,name,age,gender,email);
		model.addAttribute("msg", msg);
		
		return "index";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(Model model, HttpServletRequest req) {
		String page = "index";
		
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		logger.info("login : {} / {}",id,pw);
		
		MemberService service = new MemberService();
		String loginId = service.login(id,pw);
		logger.info("loginId : "+loginId);
		//loginId 의 null 여부에 따라 로그인 성공여부가 결정
		if(loginId != null) {// 로그인 성공
			HttpSession session = req.getSession();
			session.setAttribute("loginId", loginId);
			page = "redirect:/list"; // response.redirect() 와 같은데, 주로 다른 컨트롤러 요청을 부를때 사용한다.
		}else {//로그인 실패
			page = "index";
			model.addAttribute("msg", "아이디 또는 패스워드를 확인 하세요!");
		}				
		return page;
	}
	
	@RequestMapping(value="/list")
	public String list(Model model, HttpSession session) {		
		String loginId = (String) session.getAttribute("loginId");//로그인 안했으면 loginId 가 null
		logger.info("로그인 후 리스트 보기 : "+loginId);
		
		String page = "index";
		
		if(loginId == null) {
			model.addAttribute("msg", "로그인이 필요한 서비스 입니다.");
		}else {
			page = "main";
			MemberService service = new MemberService();
			ArrayList<MemberDTO> list = service.list();
			model.addAttribute("list", list);
		}
				
		return page;
	}
	
	@RequestMapping(value="/detail")
	public String detail(Model model, HttpServletRequest req) {		
		String id = req.getParameter("id");
		logger.info(id+" 에 대한 상세 정보");
		MemberService service = new MemberService();
		MemberDTO dto = service.detail(id);
		model.addAttribute("info", dto);		
		return "detail";
	}
	
	@RequestMapping(value="/del")
	public String del(HttpServletRequest req) {
		
		String id = req.getParameter("id");
		logger.info(id+"삭제");
		MemberService service = new MemberService();
		service.del(id);
				
		// response 객체는 데이터를 실어나를 수 없다.
		return "redirect:/list";// /list 컨트롤러 요청으로 이동
	}
	
	@GetMapping(value="/overlay.ajax")
	public @ResponseBody Map<String, Object> overlay(String id){
		
		logger.info("overlay check id : "+id);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("", "");		
		return map;
	}
	
	
	
	
	
	
	
	

}















