package kr.co.himedia.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import kr.co.himedia.dto.UserDTO;

// 외부 js 와 통신을 허용하는 옵션 추가

//@CrossOrigin(origins={"허용 url1","허용 url2"})
@CrossOrigin // 다 허용
@Controller
public class ApiController {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	// RESTful 에서는 약 5가지의 method 를 사용 한다.
	/*
	GET		: 조회할 때
	POST		: 입력할 때
	PUT		: 수정할 때
	DELETE	: 삭제할 때
	PATCH	: 일부 수정할 때
	*/
	
	// 나는 GET 요청만 받는다.
	@RequestMapping(value="/", method = RequestMethod.GET)
	@ResponseBody // resposne 는 페이지를 직접 그리는 객체이다.
	public String main() {
		//{"msg":"hello"}
		return "{\"msg\":\"hello\"}";
	}
	
	// GET 과 POST 둘 다 받고 싶다.
	@RequestMapping(value="/map", method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public Map<String, Object> map() {
		//키와 값으로 되어있는 json 과 가장 비슷한 자바 객체? 맵, 클래스
		//json array 와 가자아 비슷한 자바 객체? List
		// boot 에는 jackson 이라는 라이브러리가 내장되어 있어 비슷한 객체를 반환하면 json 형태로 변경해 준다.
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("msg", "hello");
		map.put("success", true);
		map.put("code", 200);
		return  map;
	}
	
	// GET, POST, PUT, DELETE, PATCH 다 받아준다.(보안상 좋지 않음)
	@RequestMapping(value="/object")
	@ResponseBody
	public UserDTO object() {
		UserDTO info = new UserDTO();
		info.setAge(33);
		info.setId("admin");
		info.setName("관리자");
		info.setSuccess(true);		
		return info;
	}
	
	// @XXXMaping 으로도 사용 가능
	@GetMapping(value="/list")
	@ResponseBody
	public List<String> list() {
		List<String> list = new ArrayList<String>();
		list.add("first");
		list.add("second");
		list.add("third");		
		return list;
	}
	
	
	// /get/java/1 <- restful 형태
	@GetMapping(value="/get/{lec}/{no}")
	@ResponseBody
	public Map<String, Object> pathValue(@PathVariable String lec, @PathVariable String no) {		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("msg", lec+" 과목의 "+no+" 번째글 입니다.");				
		return map;
	}
	
	
	// String -> Map 또는 Class 로 변경
	@GetMapping(value="/strMap")	
	public @ResponseBody Map<String, Object> strMap() throws Exception{
		
		// {"no":1,"msg":"map 변환 완료","name":"김지훈"}
		String json = "{\"no\":1,\"msg\":\"map 변환 완료\",\"name\":\"김지훈\"}";
		
		ObjectMapper mapper = new ObjectMapper();
		
		//그래서 특정 형태의 타입을 참조하라고 넣어주면 된다.
		//HashMap<String, Object> map = mapper.readValue(json, new TypeReference<HashMap<String, Object>>() {});	
		
		// HashMap.class 에 제너릭으로 키와 값에 대한 타입 지정이 되어있지 않다.
		 HashMap<String, Object> map = mapper.readValue(json, HashMap.class);				
		
		return map;
	}
	
	@GetMapping(value="/strObject")
	public @ResponseBody UserDTO strObject() throws Exception {
		
		// {"id":"jsonId","name":"홍길동","age":40,"success":false}
		String json = "{\"id\":\"jsonId\",\"name\":\"홍길동\",\"age\":40,\"success\":false}";
		ObjectMapper mapper = new ObjectMapper();
		
		//제너릭을 사용하지 않았다면 그냥 아래처럼 써도 경고가 없다.
		UserDTO info = mapper.readValue(json, UserDTO.class);
				
		return info;
	}
	
	

}
















