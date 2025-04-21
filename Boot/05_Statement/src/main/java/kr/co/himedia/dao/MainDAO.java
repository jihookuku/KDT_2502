package kr.co.himedia.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainDAO {
	
	Logger logger = LoggerFactory.getLogger(getClass());

	Connection conn = null;
	
	//DAO 를 객체화 == DB 에 접속 하겠다.
	//그래서 생성자에 접속 프로그래밍을 할것이다.
	public MainDAO() {//생성자
		
		String className= "org.mariadb.jdbc.Driver";
		String url = "jdbc:mariadb://localhost:3306/mydb";
		String id = "web_user";
		String pw = "pass";
		
		try {
			Class.forName(className);
			conn = DriverManager.getConnection(url, id, pw);
		} catch (Exception e) {
			e.printStackTrace();
		}		

	}

	public boolean statement() {
		
		boolean success = false;
		
		// 1. 쿼리문 준비
		String sql = "create table member("
				+ "	id varchar(50)"
				+ "	,pw varchar(100)"
				+ "	,name varchar(50)"
				+ "	,age int(3)"
				+ "	,gender varchar(4)"
				+ "	,email varchar(100)"
				+ ")";
		
		// 2. 실행
		// 2-1. 실행 객체 준비
		try {
			Statement stmt = conn.createStatement();
			int row = stmt.executeUpdate(sql);
			// 3. 오류가 안나면 성공(updated row 는 0이 나올수 밖에 없다.)
			logger.info("updated row : "+row);
			success = true;
			//DB 에서도 자원 반납은 필수
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return success;
	}

	public boolean preStatement() {
		boolean success = false;
		
		// 1. 쿼리 준비
		String sql = "INSERT INTO member(id,pw,name,age,gender,email)VALUES(?,?,?,?,?,?)";		
		// 2. 실행		
		try {
			// 2-1. PreparedStatement 생성
			PreparedStatement ps = conn.prepareStatement(sql);			
			// 2-2. ? 대응
			ps.setString(1, "admin");// ? 표 순서, 값	
			ps.setString(2, "pass");
			ps.setString(3, "관리자");
			ps.setInt(4, 20);
			ps.setString(5, "남");
			ps.setString(6, "admin@email.com");
			// 2-3. 쿼리 실행
			int row = ps.executeUpdate();
			success = row>0 ? true : false;			
			// 3. 자원반납
			ps.close();
			conn.close();			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return success;
	}

	public void resultSet() {		
		// 1. 쿼리문 준비
		String sql = "SELECT id,name,email,gender FROM member";		
		try {
			// 2-1. PreparedStatement 준비
			PreparedStatement ps = conn.prepareStatement(sql);
			// 2-2. ? 가 있다면 대응
			// 2-3. 쿼리문 수행(update ? query)
			ResultSet rs = ps.executeQuery();
			// 2-4. ResultSet 으로 부터 데이터 추출
			while (rs.next()) {
				logger.info("id : "+rs.getString(1)); // 가져오는 컬럼 순서
				logger.info("name : "+rs.getString("name")); // 또는 이름을 사용(추천)
				logger.info("email : "+rs.getString("email"));
				logger.info("gender : "+rs.getString("gender"));
			}
						
			// 3. 자원반납
			ps.close();
			rs.close();
			conn.close();			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}









