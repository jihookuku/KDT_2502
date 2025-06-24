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
	
	// 빈 등록? -> 특정한 클래스나 객체를 등록하여 스프링에서 필요할때 자유롭게 쓸수 있도록 등록하는 행위
	// 예) Spring 의 경우 xml 에 등록되어 있고, Boot 에는 위와 같이 Config 클래스에 등록되어있다.
	// 또다른 예로 @Service 나 @Component 를 @AutoWired 하는 것도 빈 등록으로 볼 수 있다.
	
	// 스프링 시큐리티의 기본기능을 끈 채로 빈을 등록
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		// csrf 공격과 방어 방법
		// csrf(Cross Site Request Forgery) : 본래 사이트가 아닌 다른사이트에서 사요자가 수행하지 않은 요청이 들어가는 행킹방법
		// 그래서 이 요청이 진짜 해당 사이트에서 발생한 것이었는지 확인이 필요
		// 이때 csrf 토큰을 통해 서버의 토큰값과 요청다의 토큰값을 비교하여 같은 사이트인지 확인한다.
		// 이 방식은 jsp 에서 form 요청을 통해 보낼때 작동 된다.
		// 그래서 토큰 값이 다르거나 없으면 403 에러를 낸다.
		// 이 에러 발생을 막기 위해서는 jsp 페이지에 csrf 토큰을 심어주거나 해당 기능을 비활성화 하면 된다.
				
		return http.httpBasic().disable().csrf().disable().build();
	}
	

	
	
	
	
	
	

}
