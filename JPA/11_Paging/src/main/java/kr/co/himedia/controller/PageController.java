package kr.co.himedia.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import kr.co.himedia.entity.Emp;
import kr.co.himedia.service.PageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequiredArgsConstructor
public class PageController {
	
	private final PageService service;
	
	//emp 와 dept 를 join 하여 2개씩 페이징 처리 하기
	@GetMapping(value="/join/{page}")
	public List<Emp> join(@PathVariable int page){
		return service.join(page,2);
	}
	
	@GetMapping(value="/fetchJoin/{page}")
	public List<Emp> fetchJoin(@PathVariable int page){
		return service.fetchJoin(page,2);
	}
	
	@GetMapping(value="/fetchJoin2/{page}")
	public List<Emp> fetchJoin2(@PathVariable int page){
		return service.fetchJoin2(page,2);
	}
	
	
	
	
	

}
