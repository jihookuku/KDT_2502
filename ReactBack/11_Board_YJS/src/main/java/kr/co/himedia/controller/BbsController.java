package kr.co.himedia.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kr.co.himedia.dto.BbsDTO;
import kr.co.himedia.service.BbsService;
import kr.co.himedia.util.JwtUtils;

@CrossOrigin
@RestController
public class BbsController {
	
	@Autowired BbsService service;
	Map<String, Object> resp=null;
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	// 로그인 토큰을 받아야할텐디…
	@GetMapping(value="/list/{id}/{page}")
	public Map<String, Object> list(
			@PathVariable String id,
			@PathVariable String page, 
			@RequestHeader Map<String, String> header){
		
		logger.info("header : {}",header);
		resp=new HashMap<String, Object>();
		boolean login = false;
		
		String token = header.get("authorization");
		Map<String, Object> payload = JwtUtils.readToken(token);
		String loginId = (String) payload.get("id");
		
		if(!loginId.equals("") && loginId.equals(id)) {
			resp = service.list(Integer.parseInt(page));
			login = true;
		}
		resp.put("loginYN", login);		
		
		return resp;
	}
	
	//detail
	@GetMapping(value="/detail/{id}/{idx}")
	public Map<String, Object> detail(
			@PathVariable String id,
			@PathVariable String idx,
			@RequestHeader Map<String, String> header){
		logger.info("id : "+id);
		logger.info("idx : "+idx);
		logger.info("header : {}",header);
		resp=new HashMap<String, Object>();
		boolean login  = false;
		String token = header.get("authorization");
		Map<String, Object> payload = JwtUtils.readToken(token);
		String loginId = (String) payload.get("id");
		
		if (!loginId.equals("") && loginId.equals(id)) {			
			BbsDTO content=service.detail(Integer.parseInt(idx), true);
			resp.put("detail", content);
			
			List<Map<String, String>> photoList = service.photoList(idx);
			resp.put("photos", photoList);			
			
			login = true;
		}
		resp.put("loginYN", login);		

		return resp;
	}
	
	// write
	@PostMapping(value="/write")
	public Map<String, Object> write(MultipartFile[] files,
			BbsDTO content,
			@RequestHeader Map<String, String> header){
		
		logger.info("header : {}",header);		
		for (MultipartFile file : files) {
			logger.info("file name : "+file.getOriginalFilename());
		}
		
		resp=new HashMap<String, Object>();
		String loginId = (String) JwtUtils.readToken(header.get("authorization")).get("id");
		boolean login = false;
		
		if(!loginId.equals("") && loginId.equals(content.getUser_name())) {
			boolean success=service.write(content,files);
			resp.put("idx", content.getIdx());
			resp.put("success", success);
			login = true;
		}
		resp.put("loginYN", login);		
		
		return resp;
	}

	@GetMapping(value="/update_view/{id}/{idx}")
	public Map<String, Object> update_view(
			@PathVariable String id, 
			@PathVariable String idx,
			@RequestHeader Map<String, String> header){
		
		logger.info("header : {}",header);		
		resp=new HashMap<String, Object>();
		String loginId = (String) JwtUtils.readToken(header.get("authorization")).get("id");
		boolean login = false;
		
		if(!loginId.equals("") && loginId.equals(id)) {
			BbsDTO content=service.detail(Integer.parseInt(idx),false);
			resp.put("idx", Integer.parseInt(idx));
			resp.put("detail", content);
			login = true;
		}
		resp.put("loginYN", login);
		
		return resp;
	}
	
	@PutMapping(value="/update")
	public Map<String, Object> update(@RequestBody BbsDTO content,
			@RequestHeader Map<String, String> header){
		
		logger.info("header : {}",header);		
		resp=new HashMap<String, Object>();
		String loginId = (String) JwtUtils.readToken(header.get("authorization")).get("id");
		boolean login = false;
		
		if(!loginId.equals("") && loginId.equals(content.getUser_name())) {
			boolean success=service.update(content);
			resp.put("success", success);
			login = true;
		}
		resp.put("loginYN", login);		

		return resp;
	}
	
	@DeleteMapping(value="/del/{id}/{idx}")
	public Map<String, Object> delete(
			@PathVariable String id, 
			@PathVariable String idx,
			@RequestHeader Map<String, String> header){
		
		logger.info("header : {}",header);		
		resp=new HashMap<String, Object>();
		String loginId = (String) JwtUtils.readToken(header.get("authorization")).get("id");
		boolean login = false;
		
		if(!loginId.equals("") && loginId.equals(id)) {
			boolean success=service.delete(Integer.parseInt(idx));
			resp.put("success", success);
			login = true;
		}
		
		resp.put("loginYN", login);		

		return resp;
	}
	
	@GetMapping(value="/photo/{file_idx}")
	public ResponseEntity<Resource> photo(@PathVariable String file_idx){
		logger.info("file idx : "+file_idx);		
		return service.getFile(file_idx,"photo");
	}
	
	@GetMapping(value="/download/{file_idx}")
	public ResponseEntity<Resource> download(@PathVariable String file_idx){
		logger.info("file idx : "+file_idx);		
		return service.getFile(file_idx,"download");
	}
	
	

}








