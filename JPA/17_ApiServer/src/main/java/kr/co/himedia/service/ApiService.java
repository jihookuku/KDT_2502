package kr.co.himedia.service;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.DefaultUriBuilderFactory;
import org.springframework.web.util.DefaultUriBuilderFactory.EncodingMode;

import reactor.core.publisher.Mono;

@Service
public class ApiService {
	
	Logger logger = LoggerFactory.getLogger(getClass());

	@Value("${api.key.encode}")
	private String apiKey;
	
	private final static String API_URL = "http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtNcst";
	
	
	// API 키가 URL 에 노출되어 나가는 경우 환경에 따라 변형이 생길수 있다.
	// 그래서 일반적으로 키는 헤더나 바디에 넣어 보내는 것을 선호한다.
	public Map<String, Object> getList(String time, String date) {
				
		Map<String, String> param = new HashMap<String, String>();
		param.put("serviceKey", apiKey);
		param.put("pageNo", "1");
		param.put("numOfRows", "1000");
		param.put("dataType", "JSON");
		param.put("base_date", date);
		param.put("base_time", time);
		param.put("nx", "60");
		param.put("ny", "127");
		
		DefaultUriBuilderFactory factory = new DefaultUriBuilderFactory(API_URL);
		factory.setEncodingMode(EncodingMode.VALUES_ONLY);		
		WebClient client = WebClient.builder().uriBuilderFactory(factory).baseUrl(API_URL).build();
		
		String queryStr = "?";
		for (String key: param.keySet()) {
			queryStr += key+"="+param.get(key)+"&";
		}		
		queryStr = queryStr.substring(0, queryStr.lastIndexOf("&"));
		logger.info(API_URL+queryStr);				
		Mono<Map> mono =  client.get().uri(queryStr).retrieve().bodyToMono(Map.class);
		
		Map<String, Object> result = mono.flux().toStream().findFirst().get();
		logger.info("result : {}",result);
		return result;
	}

}








