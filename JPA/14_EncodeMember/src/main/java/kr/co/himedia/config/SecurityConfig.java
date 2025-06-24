package kr.co.himedia.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SecurityConfig implements WebMvcConfigurer {

	//암호화 기능을 반환하는 빈을 등록
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	// 스프링 시큐리티의 기본기능을 끈 채로 빈을 등록
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		return http.httpBasic().disable().build();
	}
	
	// 빈 등록? -> 특정한 클래스나 객체를 등록하여 스프링에서 필요할때 자유롭게 쓸수 있도록 등록하는 행위
	// 예) Spring 의 경우 xml 에 등록되어 있고, Boot 에는 위와 같이 Config 클래스에 등록되어있다.
	// 또다른 예로 @Service 나 @Component 를 @AutoWired 하는 것도 빈 등록으로 볼 수 있다.
	
	
	
	
	
	

}
