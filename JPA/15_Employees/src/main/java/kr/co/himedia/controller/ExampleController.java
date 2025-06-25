package kr.co.himedia.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.himedia.service.ExampleService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ExampleController {
	
	private final ExampleService service;
	
	// 사원들의 이름(성과 이름을 합쳐서)과 입사일, 직책을 입사일이 빠른 순으로 보여주시오
	@GetMapping("/exam/1")
	public List<Map<String, Object>>exam1(){
		return service.exam1();
	}


	//여러 팀에 배정된 사원의 이름을 가져 오시오
	@GetMapping("/exam/2")
	public List<String> exam2(){
		return service.exam2();
	}
		
	// 그럼 각 인원이 어떤 팀에서 어떤 팀으로 이동했는지 알아보자
	@GetMapping("/exam/3")
	public List<Map<String, Object>> exam3(){
		return service.exam3();
	}
		
	// 위 내용을 join 활용해서도 풀어보자!
	@GetMapping("/exam/4")
	public List<Map<String, Object>>exam4(){
		return service.exam4();
	}
		
	// 현 팀장들의 이름, 성별, 입사일, 직책, 직책 기간
	//@GetMapping("/exam/5")

		
	// 사원들의 사번, 이름, 현재 직책과 급여
	//@GetMapping("/exam/6")
	
}
