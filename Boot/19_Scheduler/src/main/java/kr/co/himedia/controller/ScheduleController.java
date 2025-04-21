package kr.co.himedia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ScheduleController {
	
	@RequestMapping(value="/")
	public @ResponseBody String home() {		
		//{"msg":"스케쥴러 가동 중 입니다."}		
		return "{\"msg\":\"스케쥴러 가동 중 입니다.\"}";
	}

}
