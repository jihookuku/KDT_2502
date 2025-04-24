package kr.co.himedia.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

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
			List<BbsDTO> list=service.list(Integer.parseInt(page));
			resp.put("list", list);
			login = true;
		}
		resp.put("loginYN", login);		
		
		return resp;
	}
	
	//detail
	@GetMapping(value="/detail/{idx}")
	public Map<String, Object> detail(@PathVariable String idx){
		resp=new HashMap<String, Object>();
		BbsDTO content=service.detail(Integer.parseInt(idx));
		resp.put("detail", content);
		return resp;
	}
	
	// write
	@PostMapping(value="/write")
	public Map<String, Object> write(@RequestBody BbsDTO content){
		resp=new HashMap<String, Object>();
		boolean success=service.write(content);
		resp.put("idx", content.getIdx());
		resp.put("success", success);
		return resp;
	}
	
	// 흑흑흑흑하기싫어엉
	@GetMapping(value="/update_view/{idx}")
	public Map<String, Object> update_view(@PathVariable String idx){
		resp=new HashMap<String, Object>();
		BbsDTO content=service.detail(Integer.parseInt(idx));
		resp.put("idx", Integer.parseInt(idx));
		resp.put("detail", content);
		return resp;
	}
	
	@PutMapping(value="/update")
	public Map<String, Object> update(@RequestBody BbsDTO content){
		resp=new HashMap<String, Object>();
		boolean success=service.update(content);
		resp.put("success", success);
		return resp;
	}
	
	@DeleteMapping(value="/del/{idx}")
	public Map<String, Object> delete(@PathVariable String idx){
		resp=new HashMap<String, Object>();
		boolean success=service.delete(Integer.parseInt(idx));
		resp.put("success", success);
		return resp;
	}
	
	

}
