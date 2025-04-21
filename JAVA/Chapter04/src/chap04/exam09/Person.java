package chap04.exam09;

public class Person {
	
	final String nation;
	//static final 은 생성자 사용이 불가하므로 소스에 값을 넣어줘야 한다.
	static final String ssn = "800902-1234567";
	final String name;

	//final 은 생성자를 통해 초기화 해줘야 한다.
	public Person(String nation, String name) {
		this.nation = nation;
		this.name = name;
	}

}
