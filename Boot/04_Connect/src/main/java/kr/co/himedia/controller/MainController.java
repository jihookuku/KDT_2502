package kr.co.himedia.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.himedia.service.MainService;

@Controller
public class MainController {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@RequestMapping(value="/")
	public String dbConnect(Model model) {
		
		logger.info("컨트롤러 접근");
		System.out.println("컨트롤러 접근");
		
		MainService service = new MainService();
		boolean success = service.dbConnect();
		logger.info("서비스로부터 돌아온 값 : "+success);
		model.addAttribute("success", success);
				
		return "home";
	}

}








