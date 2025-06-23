package kr.co.himedia.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import kr.co.himedia.util.LoginChecker;
import lombok.RequiredArgsConstructor;

// 이 어노테이션이 있어야 설정 빈으로 인식한다.
@Configuration
@RequiredArgsConstructor
public class InterCeptorConfig implements WebMvcConfigurer {

	
	private final LoginChecker checker;
	
	// 인터셉터를 가동하거나 예외를 줄 url 패턴을 정의 하고
	// 인터셉터에 걸렸을때 무엇을 할지 지정
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		List<String> excludeList = new ArrayList<String>(); //예외 url 리스트
		excludeList.add("/");
		excludeList.add("/login.*"); // login. 뒤에 뭐가 오던지...
		excludeList.add("/join*");//join 뒤에 뭐가 오던지...
		excludeList.add("/overaly*");//overlay 뒤에 뭐가 오던지
		excludeList.add("/resources/**");// resources/ 뒤에 어떤 경로가 오던지
		
		registry.addInterceptor(checker) // 어떤 수행을 해야해?(수횅할 클래스 지정)
		.addPathPatterns("/**")			// 어떤 url 을 잡아야해?
		.excludePathPatterns(excludeList);	// 어떤 url 을 예외로 해줘야해?

	}
	
	

}
