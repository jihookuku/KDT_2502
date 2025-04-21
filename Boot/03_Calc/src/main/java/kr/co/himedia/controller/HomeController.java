package kr.co.himedia.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	@RequestMapping(value="/")
	public String home() {
		System.out.println("/ 요청 받음");
		return "home";
	}
	
	// calc 요청을 받는데, 오직 POST 로 보낼 경우만 받겠다.
	@RequestMapping(value="/calc",method = RequestMethod.POST)
	public String calc(Model model, HttpServletRequest request) {
		
		String val1 = request.getParameter("val1");
		String oper = request.getParameter("oper");
		String val2 = request.getParameter("val2");
		System.out.println(val1+oper+val2+"=?");
		
		int su1 = Integer.parseInt(val1);
		int su2 = Integer.parseInt(val2);
		int result = 0;
		
		switch (oper) {
		case "+":
			result = su1 + su2;
			break;
			
		case "-":
			result = su1-su2;
			break;
			
		case "*":
			result = su1 * su2;
			break;
			
		case "/":
			result = su1 / su2;
			break;
		}
		
		model.addAttribute("result", result);		
		
		return  "result";
	}

}
















