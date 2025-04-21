package kr.co.himedia.controller;

import java.util.Arrays;
import java.util.List;

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
import org.springframework.web.multipart.MultipartFile;

import kr.co.himedia.service.FileService;

@Controller
public class FileController {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired FileService service;
	
	@RequestMapping(value="/")
	public String main() {
		return "main";
	}
	
	@PostMapping(value="/upload")
	public String upload(MultipartFile uploadFile) {
		logger.info("name : "+uploadFile.getOriginalFilename());
		service.upload(uploadFile);		
		return "redirect:/photoList";
	}
	
	@PostMapping(value="/multiUpload")
	public String multiUpload(MultipartFile[] files) {
		logger.info("file count : "+files.length);
		service.multiUpload(files);		
		return "redirect:/photoList";
	}
	
	@GetMapping(value="/photoList")
	public String photoList(Model model) {		
		String[] list = service.photoList();		
		logger.info(Arrays.toString(list));		
		model.addAttribute("list", list);		
		return "result";
	}
	
	@GetMapping(value="/delFile")
	public String delFile(String file) {		
		service.delFile(file);		
		return "redirect:/photoList";
	}
	
	@GetMapping(value="/download")
	public ResponseEntity<Resource> download(String file) {
		return service.download(file);
	}
	

}












