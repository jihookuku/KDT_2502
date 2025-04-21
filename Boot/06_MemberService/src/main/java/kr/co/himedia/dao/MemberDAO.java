package kr.co.himedia.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.himedia.dto.MemberDTO;

public class MemberDAO {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	Connection conn = null;
	
	public MemberDAO() {
		
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

	public int join(String id, String pw, String name, int age, String gender, String email) {		
		// 1. 쿼리문 준비
		String sql = "INSERT INTO member(id,pw,name,age,gender,email)VALUES(?,?,?,?,?,?)";
		int row = 0;				
		try {
			// 2-1. PreparedStatement 준비
			PreparedStatement ps = conn.prepareStatement(sql);			
			// 2-2. ?표 대응
			ps.setString(1, id);
			ps.setString(2, pw);
			ps.setString(3, name);
			ps.setInt(4, age);
			ps.setString(5, gender);
			ps.setString(6, email);			
			// 2-3. 실행(update ? qurey)
			row = ps.executeUpdate();			
			// 3. 자원반납
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}

	public String login(String id, String pw) {
		
		// 1. 쿼리문 준비
		String sql="select id from member where id = ? and pw = ?";
		String loginId = null;
				
		try {
			// 2. PreparedStatement 준비
			PreparedStatement ps = conn.prepareStatement(sql);
			// 3. ? 대응
			ps.setString(1, id);
			ps.setString(2, pw);
			
			// 4. 쿼리 실행
			ResultSet rs = ps.executeQuery();
			
			// 5. 데이터 꺼내기
			if(rs.next()) {
				loginId = rs.getString("id");
			}
						
			// 6. 자원 반납
			ps.close();
			rs.close();
			conn.close();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return loginId;
	}

	public ArrayList<MemberDTO> list() {		
		String sql = "SELECT id,name,email FROM member"; // 1. 쿼리문 준비				
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		try {			
			PreparedStatement ps = conn.prepareStatement(sql);// 2. PreparedStatement 생성
			
			// 3. ? 가 있으면 대응			
			ResultSet rs = ps.executeQuery();// 4. 쿼리실행(update|query)						
			// 5. ResultSet 으로부터 데이터 추출
			while(rs.next()) {
				MemberDTO dto = new MemberDTO();
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setEmail(rs.getString("email"));
				list.add(dto);
			}			
			// 6. 자원반납
			ps.close();
			rs.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;		
	}

	public MemberDTO detail(String id) {				
		String sql = "SELECT id,pw,name,age,gender,email FROM member WHERE id = ?";// 1. 쿼리문 준비
		MemberDTO dto = null;				
		try {
			PreparedStatement ps = conn.prepareStatement(sql);// 2. PreparedStatement 준비			
			ps.setString(1, id);// 3. ? 대응
			ResultSet rs = ps.executeQuery();// 4. 쿼리 실행(update\query)			
			
			if(rs.next()) {// 5. ResultSet 으로부터 데이터 추출
				dto = new MemberDTO();
				dto.setId(rs.getString("id"));
				dto.setPw(rs.getString("pw"));
				dto.setName(rs.getString("name"));
				dto.setAge(rs.getInt("age"));
				dto.setGender(rs.getString("gender"));
				dto.setEmail(rs.getString("email"));
			}					
			// 6. 자원 반납
			ps.close();
			rs.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return dto;
	}

	public void del(String id) {		
		String sql = "DELETE FROM member WHERE id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			int row = ps.executeUpdate();
			logger.info("delete row : "+row);
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}

}
























