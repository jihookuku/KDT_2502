package chap06.exam01;

public class Person extends Mammal {

	public Person(String name) {
		super(name); // 부모 생성자에 받아온 name 을 넘겨준다.
	}
	
	// Mammal 을 상속 받고 있기 때문에, Mammal 의 name 을
	// 지금 Person 에 있는 것처럼 쓸 수 있다.
	public void useTool() {
		System.out.println(name+" 가 도구를 쓴다.");
	}
	
	public void social() {
		System.out.println(name+" 가 사회생활을 한다.");
	}
	
	public void talk() {
		System.out.println(name+" 가 대화를 한다.");
	}

}
