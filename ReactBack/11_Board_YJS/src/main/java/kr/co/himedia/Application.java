package kr.co.himedia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import kr.co.himedia.util.JwtUtils;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		
		if(JwtUtils.getPri_key()==null) {
			JwtUtils.setPri_key();
		}
	}

}
