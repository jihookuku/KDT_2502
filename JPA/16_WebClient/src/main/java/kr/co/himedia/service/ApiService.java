package kr.co.himedia.service;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@Service
public class ApiService {
	
	Logger logger = LoggerFactory.getLogger(getClass());

	/* Spring 에서는 HttpConnection 이라는 객체로 통신을 했다.
	 * 이후 RestTemplate -> WebClient 로 발전해 왔다.
	 * WebClient 는 Spring 5.0 에서 부터 지원 한다.
	 * Boot 2 버전 부터 가능
	 * 비동기 방식을 지원하여 속도가 더 빠르다.
	 */	
	public Map<String, Object> getSend(String msg) {
		
		WebClient client = WebClient.create("http://localhost:8080");
		
		Mono<HashMap> mono= client.get() //전송방식(get,post,put,patch,delete)
				.uri("/return/"+msg) // url : get 방식은 여기에 ? 를 이용해 파라메터를 붙인다.
				.retrieve()	//전송(body 값만 가져오는 기능), exchange() 헤더와 상태값도 받아온다.
				.bodyToMono(HashMap.class);// 받아오는 방식(비동기 방식)
		
		Map<String, Object> map = mono.block();
		logger.info("result : "+map);		
		return map;
	}

}













