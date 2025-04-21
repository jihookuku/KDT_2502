package kr.co.himedia.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	// localhost:8080 요청이 오면, 아래 메서드를 실행 해라
	@RequestMapping(value="/")
	public String home(Model model) {
		System.out.println("홈 메서드 실행!!");
		//model 은 view 로 데이터를 보낼때 사용(MVC 의 modle 과 다름)
		model.addAttribute("msg", "서버에서 보낸 메시지");
		return "main"; // /views/main.jsp
	}
	
	
	@RequestMapping(value="/message")
	public String message(Model model, HttpServletRequest request) {
		
		String param = request.getParameter("param");
		System.out.println("param : "+param);
		
		if(param == null) {
			model.addAttribute("msg", "파라메터 값을 입력해 주세요");
		}else if(param.equals("greeting")) {
			model.addAttribute("msg", "안녕하세요");
		}else if(param.equals("date")) {
			model.addAttribute("msg", new Date());
		}else {
			model.addAttribute("msg", "invalid type");
		}
				
		return "main";
	}
	
	

}















