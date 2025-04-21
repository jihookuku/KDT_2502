package kr.co.himedia.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	@RequestMapping(value={"/"})
	public String main() {
		return "index";
	}
	
	@RequestMapping(value="/join.go")
	public String joinForm() {
		return "joinForm";
	}
	
	// DTO 형태로도 파라메터를 받을 수 있다.
	@PostMapping(value="/join.do")
	public String join(Model model, MemberDTO dto) {
		logger.info("회원가입 : {}",dto.getId());
		service.join(dto);
		return "redirect:/list.do";
	}

	@RequestMapping(value="/list.do")
	public String list(Model model, 
			@RequestParam Map<String,String> param) {

		logger.info("param : {}",param);
		ArrayList<MemberDTO> list = service.list(param);
		model.addAttribute("list",list);
		
		return "main";
	}
	

	@PostMapping(value="/multi.do")
	public String multi(Model model, 
			@RequestParam List<String> userName ) {
		logger.info("userName : {}",userName);
		
		List<MemberDTO> list = service.multi(userName);
		model.addAttribute("list", list);		
		return "main";
	}
	
	@GetMapping(value="/detail.do")
	public String detail(Model model, String id) {
		logger.info("id="+id);
		
		MemberDTO dto = service.detail(id);
		model.addAttribute("dto", dto);
		
		return "detail";
	}
	
	//json 을 문자열화 해서 보냈을  때는 RequestParam 을 사용할 수 없다.
	// 대신 @RequestBody 를 사용해 준다.
	@PostMapping(value="/update.ajax")
	public @ResponseBody Map<String, Object> update(
			@RequestBody Map<String, String> param){
		
		logger.info("param : {}",param);
		
		int row = service.update(param);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success", row);
		
		
		return map;
	}
	
	

	
}















