package chap06.exam01;

public class Main {

	public static void main(String[] args) {
		
		Person p = new Person("순이");
		p.birth();
		p.eat();
		p.useTool();
		p.social();
		p.talk();
		
		// 추상클래스는 자식 외에는 객체화 할 수 없다.
		// Mammal ma = new Mammal("순이");

	}

}
