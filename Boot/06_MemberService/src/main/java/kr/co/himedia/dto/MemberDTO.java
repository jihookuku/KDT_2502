package kr.co.himedia.dto;

//Data Transfer Object 또는  Beans 라고 부른다.
// 빈즈를 만들때 규칙
// - 캡슐화를 활용해야 한다.
// - DB 의 컬럼명과 필드명을 일치시켜 준다.
public class MemberDTO {
	
	private String id;
	private String pw;
	private String name;
	private int age;
	private String gender;
	private String email;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}	

}
