package kr.co.himedia.dao;

import java.sql.Connection;
import java.sql.DriverManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainDAO {	
	Logger logger = LoggerFactory.getLogger(getClass());

	public boolean dbConnect() {		
		logger.info("DAO 접근!");		
		// 1. DB 접속에 필요한 준비물
		String className= "org.mariadb.jdbc.Driver";
		String url = "jdbc:mariadb://localhost:3306/mydb";
		String id = "web_user";
		String pw = "pass";
		
		boolean success = false;
		
		// 2. DriverManager 에게 DB 를 가져오라고 요청
		try {
			Class.forName(className);// 이 클래스를 메모리에 등록해 놓으면 DriverManager 가 알아서 가져다 쓴다.			
			// 3. 디비를 접속해서 가져옴(Connection 객체의 형태로...)
			Connection conn = DriverManager.getConnection(url, id, pw);			
			if(conn != null) {
				success = true;
			}			
			// 4. 디비에서 할 일들을 하고(X)			
			// 5. Connection 을 반납 한다.
			conn.close();			
		} catch (Exception e) {
			e.printStackTrace();
		}						
		return success;
	}

}
