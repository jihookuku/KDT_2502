package kr.co.himedia.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.himedia.service.UserService;

@Controller
public class UserController {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	// application.properties 에서 원하는 값을 가져오는 경우...
	@Value("${spring.application.name}")
	private String name;
	
	@Value("${logging.level.root}")
	private String log_level;
	
	@Value("${server.port}")
	private String port;
	
	@Autowired UserService service;
	
	@RequestMapping(value="/")
	public String home() {
		logger.info("name="+name);
		logger.info("log level="+log_level);
		logger.info("port="+port);		
		return "home";
	}
	
	@PostMapping(value="/login.do")
	public String login(Model model, HttpServletRequest req) {
		
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String perm = req.getParameter("permission");
		String ip = req.getRemoteAddr();
		
		logger.info(id+"/"+pw+"/"+perm+"/"+ip);
		String msg = service.login(id,pw,perm,ip);
		model.addAttribute("msg", msg);
		
		return "result";
	}

}































