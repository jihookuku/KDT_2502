package kr.co.himedia.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	
	// 암호화를 위한 인코더 등록
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	//스프링 시큐리티의 암호화 기능만을 사용하고 나머지는 모두 비활성화 해 준다.
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		//로그인 기본 설정을 비활성화
		http.httpBasic().disable();		
		return http.build();
	}

}






