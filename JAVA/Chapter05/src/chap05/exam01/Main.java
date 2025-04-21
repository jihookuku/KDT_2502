package chap05.exam01;

public class Main {

	public static void main(String[] args) {
		
		// 일반적인 객체 사용 방법
		Mammal ma = new Mammal();		
		ma.birth();// Mammal 의 birth() 호출		
		ma.eat();// Mammal 의 eat() 호출
		
		Person person = new Person();		
		person.useTool();// Person 의 useTool() 호출		
		person.social();// Person 의 social() 호출

		//상속활용(내것처럼 == 자식객체에서 부모 멤버 사용)
		person.birth();
		person.eat();
		
		// 상속을 활용하면 하나만 객체화 하여 부모의 멤버도 사용할수 있으므로 편의성 측면에서 유리하다.
		
	}

}
