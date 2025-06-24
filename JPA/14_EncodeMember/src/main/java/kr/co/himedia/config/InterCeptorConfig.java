package kr.co.himedia.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterCeptorConfig implements WebMvcConfigurer{

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		// list 로 시작되는 url 에 대해서만 인터셉터로 잡는다.
		registry.addInterceptor(null).addPathPatterns("/list*");

	}
	
	

}
