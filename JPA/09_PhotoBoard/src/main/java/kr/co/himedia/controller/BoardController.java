package kr.co.himedia.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import kr.co.himedia.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController // view 를 반환 할 수 없다.
@Slf4j
@RequiredArgsConstructor
public class BoardController {
	
	private final BoardService service;

	// @RestController 에서는 일반적인 방법으로 String 반환으로 원하는 페이지 이동이 불가능 하다.
	@GetMapping(value="/")
	public ModelAndView main() {
		//ModelAndView = model + view(객체)
		//원하는 곳에서 생성해서 쓰면 된다.
		ModelAndView mav = new ModelAndView();
		mav.setViewName("list");		
		return mav;
	}
	
	@GetMapping(value="/list/{no}")
	public Map<String, Object> list(@PathVariable int no){
		log.info("page : "+no);		
		return service.list(no);
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
