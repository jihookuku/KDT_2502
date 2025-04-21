package kr.co.himedia.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.himedia.dto.BoardDTO;
import kr.co.himedia.service.BoardService;

@Controller
public class BoardController {
	
	Logger logger = LoggerFactory.getLogger(getClass());	
	@Autowired BoardService service;
	
	@RequestMapping(value={"/","/list"})
	public String list(Model model) {		
		ArrayList<BoardDTO> list = service.list();
		model.addAttribute("list", list);		
		return "list";
	}
	
	@GetMapping(value="/writeForm")
	public String writeForm() {
		return "writeForm";
	}
	
	@PostMapping(value="/write")
	public String write(String subject, String user_name, String content) {
		logger.info(subject+"/"+user_name+"/"+content);		
		service.write(subject,user_name,content);		
		return "redirect:/";
	}
	
	@GetMapping(value="/detail")
	public String detail(Model model, String idx) {
		logger.info("detail : "+idx);
		BoardDTO dto = service.detail(idx);
		model.addAttribute("bbs", dto);		
		return "detail";
	}
	
	@GetMapping(value="/del")
	public String del(String idx) {
		logger.info("delete idx="+idx);
		int row = service.del(idx);
		logger.info("delete row : "+row);
		return "redirect:/";
	}
	
	@GetMapping(value="/updateForm")
	public String updateForm(Model model, String idx) {
		BoardDTO dto = service.updateForm(idx);
		model.addAttribute("bbs", dto);	
		return "updateForm";
	}
	

}


















