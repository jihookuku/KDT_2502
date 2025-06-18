package kr.co.himedia.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="employee") // 설정을 안하면 클래스명을 따라감
public class Employees {
	
	@Id // pk 를 의미함
	@Column(nullable = false)// null 을 허용하지 않음
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int no;
	/* INDENTITY	: auto_increment(mysql, mariadb, postgre)
	 * AUTO			: 하이버네이트 에서 자동으로 선택
	 * SEQUENCE	: 별도의 객체를 사용(Oracle, postgre)
	 * TABLE			: 키 값을 별도의테이블에서 관리(모든 DB)
	 */
	
	private int age;
	
	@Column(length = 25) // 길이를 25자로 제한
	private String name;
	
	private String email; // 크기를 지정하지 않으면 JPA 내부의 기본크기로 지정
	
	//long text
	@Lob
	@Column(columnDefinition = "longtext")
	private String content;

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}	

}
