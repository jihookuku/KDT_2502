package kr.co.himedia.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import kr.co.himedia.util.LoginChecker;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class InterCeptorConfig implements WebMvcConfigurer{

	private final LoginChecker checker;
	
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		// list 로 시작되는 url 에 대해서만 인터셉터로 잡는다.
		registry.addInterceptor(checker)
		.addPathPatterns("/list*");

	}
	
	

}
