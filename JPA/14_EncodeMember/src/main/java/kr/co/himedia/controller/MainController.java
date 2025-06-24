package kr.co.himedia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequiredArgsConstructor
public class MainController {
	
	@GetMapping(value="/")
	public String home() {
		return "login";
	}
	
	
	@GetMapping(value="/{page}.go")
	public String move(@PathVariable String page) {
		return page;
	}
	

}





