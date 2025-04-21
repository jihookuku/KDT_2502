package kr.co.himedia.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

// ErrorController 인터페이스를 구현받지 않으면 /error 요청에 대해서 중복으로 인식하게 된다.
@Controller
public class ErrorHandlerController implements ErrorController {
	
	// POST, GET, DELETE, PUT, PATCH, UPDATE 
	@RequestMapping(value="/error")
	public String error(Model model, HttpServletRequest req) {
		
		//404, 405, 403, 400, 500
		int code = (int) req.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		
		String msg = "<h2>"+code+" ERROR</h2>";
		
		switch (code) {
		case 400:
			msg += "<h3>입력 파라메터의 갯수가 맞지 않습니다.</h3>";
			break;
			
		case 403:
			msg += "<h3>권한이 없습니다.</h3>";
			break;
			
		case 404:
			msg += "<h3>찾으시는 요청이 컨트롤러에 존재하지 않습니다.</h3>";
			break;
			
		case 405:
			msg += "<h3> 사용하는 메서드가 컨트롤러와 일치하지 않습니다.</h3>";
			break;
			
		case 500:
			msg += "<h3>서버에서 처리중 문제가 발생 했습니다.</h3>";
			break;

		default:
			msg += "<h3>알 수 없는 에러(에러 코드로 인터넷에 찾아 보세요)</h3>";
			break;
		}
		
		model.addAttribute("msg", msg);
				
		return "error";
	}

}











