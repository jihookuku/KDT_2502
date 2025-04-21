package kr.co.himedia.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

//classpath <- 실제 소스가 동작되는 프로그램으로 컴파일 되었을때의 경로(classes 폴더)
@Service
@PropertySource("classpath:super_admin.properties")
public class UserService {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Value("${user.id}") private String admin_id;
	@Value("${user.pw}") private String admin_pw;
	@Value("${user.ip}") private String admin_ip;

	public String login(String id, String pw, String perm, String ip) {
		
		int success = 0;
		
		if(perm.equals("admin")) {
			if(id.equals(admin_id) && pw.equals(admin_pw) && ip.equals(admin_ip)) {
				success = 1;
			}			
		}else {
			// DAO 를 통해 member 테이블에 요청
		}

		return success > 0 ? "로그인에 성공 했습니다." : "로그인에 실패 했습니다.";
	}

}






