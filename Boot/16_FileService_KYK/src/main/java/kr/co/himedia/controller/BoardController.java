package kr.co.himedia.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
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
import org.springframework.web.multipart.MultipartFile;

import kr.co.himedia.dto.BoardDTO;
import kr.co.himedia.dto.MemberDTO;
import kr.co.himedia.dto.PhotoDTO;
import kr.co.himedia.service.BoardService;
import kr.co.himedia.service.MemberService;

@Controller
public class BoardController {

	Logger logger = LoggerFactory.getLogger(getClass());
	
	
	@Autowired BoardService bbs_service;
	
	@RequestMapping(value = "/list.do")
	public String list(Model model, HttpSession session) {
		
		String page = "redirect:/";
		
		if (session.getAttribute("loginId") != null) {
			
			ArrayList<BoardDTO> list = bbs_service.list();
			model.addAttribute("list", list);
			page = "list";
		}
		
		return page;
	}
	
	@RequestMapping(value = "/del.do")
	public String del(String idx, HttpSession session) {
		String page = "redirect:/";
		if (session.getAttribute("loginId") != null) {
			logger.info("delete idx : " + idx);
			bbs_service.del(idx);
			page = "redirect:/list.do";
		}
		return page;
	}
	
		
	@GetMapping(value = "/write.go")
	public String writeForm(HttpSession session) {
		return session.getAttribute("loginId") != null ? "writeForm" : "redirect:/";
	}
	

	@PostMapping(value = "/write.do") // 
	public String write(String subject, String user_name, String content, HttpSession session, MultipartFile[] files) {

		String page = "redirect:/";
		if (session.getAttribute("loginId") != null) {
			logger.info(subject + " / " + user_name + " / " + content);
			int idx = bbs_service.write(subject, user_name, content,files);
			page = "redirect:/detail.do?idx="+idx;
		}
		return page;
	}

	
	@GetMapping(value = "/detail.do")
	public String detail(Model model, String idx, HttpSession session) {
		
		String page = "redirect:/";
		
		if (session.getAttribute("loginId") != null) {
		
		logger.info("detail : " + idx);
		BoardDTO dto = bbs_service.detail(idx);
		List<PhotoDTO> list = bbs_service.photos(idx);
		model.addAttribute("bbs", dto);
		model.addAttribute("photos", list);
		page = "detail";
		
		}
		return page;
	}

	
	@GetMapping(value = "/update.go")
	public String updateForm(Model model, String idx, HttpSession session) {
		
		String page = "redirect:/";
		
		if (session.getAttribute("loginId") != null) {		
			BoardDTO dto = bbs_service.updateForm(idx);
			List<PhotoDTO> list = bbs_service.photos(idx);
			
			model.addAttribute("bbs", dto);
			model.addAttribute("photos", list);
			page = "updateForm";
		}
		return page;
	}
	
	@PostMapping(value = "/update.do") 
	public String update(
			MultipartFile[] files,
			@RequestParam Map<String, String> param, 
			HttpSession session) {		
		String page = "redirect:/";		
		if (session.getAttribute("loginId") != null) {					
			bbs_service.update(param, files);
			page = "redirect:/detail.do?idx="+param.get("idx");
		}
		
		return page;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

