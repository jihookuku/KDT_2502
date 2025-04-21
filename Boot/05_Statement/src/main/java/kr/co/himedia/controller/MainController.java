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
	public String main() {
		logger.info("main 페이지 요청");
		return "main";
	}
	
	@RequestMapping(value="/statement")
	public String statement(Model model) {
		logger.info("statement 요청");
		MainService service = new MainService();
		boolean success = service.statement();
		model.addAttribute("success", success);
		return "result";
	}
	
	@RequestMapping(value="/preStatement")
	public String preStatement(Model model) {
		logger.info("prepared statement 요청");
		MainService service = new MainService();
		boolean success = service.preStatement();
		model.addAttribute("success", success);		
		return "result";
	}
	
	@RequestMapping(value="/resultSet")
	public String resultSet(Model model) {
		logger.info("result set 요청");		
		MainService service = new MainService();
		service.resultSet();				
		return "result";
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
