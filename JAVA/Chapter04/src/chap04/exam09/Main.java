package chap04.exam09;

public class Main {

	public static void main(String[] args) {
		
		Person p = new Person("KOREA", "김지훈");
		// final 은 생성자에서 초기화 한 이후 변경이 불가능 하다.
		//p.name = "kim,ji-hoon";
		//p.nation = "한국";
		
		System.out.println(PersonInfo.NAME);
		System.out.println(PersonInfo.GENDER);
		System.out.println(PersonInfo.SSN);
	}

}
