package kr.co.himedia.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
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
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired BoardService service;
	
	@RequestMapping(value= {"/","list"})
	public String list (Model model) {
		ArrayList<BoardDTO> list =service.list();
		model.addAttribute("list",list);
		return "list";
	}
	
	@GetMapping(value="/writeForm")
	public String writeForm() {
		return "writeForm";
	}
	
	@PostMapping(value="/write")
	public String write(
			MultipartFile[] files,
			String subject, String user_name, String content) {
		logger.info("file count : "+files.length);
		logger.info(subject + "/" + user_name + "/" + "content");
		int idx = service.write(subject,user_name,content, files);
		return "redirect:/detail?idx="+idx;
	}
	
	@GetMapping(value = "/del")
	public String del(String idx) {
		logger.info("delete idx = " + idx);
		int row = service.del(idx);
		logger.info("delete row : " + row);
		return "redirect:/";
	}
	
	@GetMapping(value="/detail")
	public String detail(Model model, String idx) {
		logger.info("detail : " + idx);
		BoardDTO dto = service.detail(idx);
		List<PhotoDTO> list = service.photos(idx);		
		model.addAttribute("bbs", dto);
		model.addAttribute("photos", list);
		return "detail";
	}
	
	@GetMapping(value="/updateForm")
	public String updateForm(Model model, String idx) {
		logger.info("updateForm : " + idx);
		BoardDTO dto=service.updateForm(idx);
		model.addAttribute("bbs",dto);
		
		List<PhotoDTO> list = service.photos(idx);	
		model.addAttribute("photos", list);
		
		return "updateForm";
	}
	
	
	@PostMapping(value="/update")
	public String update(
			MultipartFile[] files,
			@RequestParam Map<String, String>param) {
		String idx = param.get("idx");
		String page = "redirect:/updateForm";
		logger.info("params : {}", param);
		
		if (service.update(param,files)>0) {
			page = "redirect:/detail?idx=" + idx;
		}		
		
		return page;
	}
	
	@GetMapping(value="/download")
	public ResponseEntity<Resource> download(String idx) {
		return service.download(idx);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
