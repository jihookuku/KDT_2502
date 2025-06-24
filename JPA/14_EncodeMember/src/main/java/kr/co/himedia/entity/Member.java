package kr.co.himedia.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Member {
	
	@Id
	private String id;
	
	private String pw;
	
	private String name;
	
	private String age; 
	
	private String gender;
	
	private String email;

}
