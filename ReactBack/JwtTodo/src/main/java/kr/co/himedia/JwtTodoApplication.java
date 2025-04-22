package kr.co.himedia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import kr.co.himedia.utils.JwtUtils;

@SpringBootApplication
public class JwtTodoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwtTodoApplication.class, args);
		System.out.println("서버가 켜졌을때 실행되는 메서드");
		
		//private key 가 없으면 생성 한다.
		if(JwtUtils.getPri_key() == null) {
			JwtUtils.setPri_key();
		}
		
		
	}

}
