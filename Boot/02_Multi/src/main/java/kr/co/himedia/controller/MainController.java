package kr.co.himedia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@RequestMapping(value="/")
	public String home(Model model) {
		model.addAttribute("msg", "home page 입니다.");
		return "home";
	}
	
	@RequestMapping(value="/main")
	public String main(Model model) {
		model.addAttribute("msg", "main page 입니다.");
		return "main";
	}
	
	@RequestMapping(value="/index")
	public String index(Model model) {
		model.addAttribute("msg", "index page 입니다.");
		return "index";
	}	
	

}
