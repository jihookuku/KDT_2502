package kr.co.himedia.controller;

import java.util.ArrayList;
import java.util.List;
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
import org.springframework.web.multipart.MultipartFile;

import kr.co.himedia.dto.BoardDTO;
import kr.co.himedia.dto.PhotoDTO;
import kr.co.himedia.service.BoardService;

@Controller
public class BoardController {

	Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	BoardService service;
	
	@RequestMapping(value= {"/","list"})
	public String list(Model model) {
		
		ArrayList<BoardDTO> list = service.list();
		
		model.addAttribute("list",list);
		
		return "list";
	}
	
	@GetMapping(value="/writeForm")
	public String writeForm() {
		return "writeForm";
	}
	
	@PostMapping(value="/write")
	public String write(MultipartFile[] files ,String subject, String user_name, String content) {		
		log.info("file count : "+files.length);
		log.info(subject+"/"+user_name+"/"+content);
		service.write(subject,user_name,content,files);		
		return "redirect:/";
	}
	
	@RequestMapping(value="/detail")
	public String detail(String idx,Model model) {
		BoardDTO dto = service.detail(idx);	
		List<PhotoDTO> list = service.photos(idx);
		model.addAttribute("bbs",dto);		
		model.addAttribute("photos", list);
		return "detail";
	}
	
	@GetMapping(value="/del")
	public String del(String idx) {
		service.del(idx);
		return "redirect:/list";
	}
	
	@RequestMapping(value="/updateForm")
	public String updateForm(String idx,Model model) {

		BoardDTO dto = service.updateForm(idx);
		
		model.addAttribute("bbs",dto);
		
		return "updateForm";
	}
	
	@PostMapping(value="/update")
	public String update(@RequestParam Map<String, String> param) {
		
		service.update(param);
		
		return "redirect:/list";
	}
	
	
}
