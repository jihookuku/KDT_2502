package chap04.exam03;


public class Student {
	// main 메서드가 없어서 누군가 불러줘야 한다.
	// 이름이 Student 인것으로 보아 학생과 관련된 메서드나 변수가 있을것 같다.
	
	/**
	 * 이름을 입력하면 학생명이 되어서 반환되는 메서드
	 * @param name 학생이 될 이름
	 * @return 학생이 된 이름
	 */
	String getName(String name) {
		return "학생명 : "+name;
	}
	
}
