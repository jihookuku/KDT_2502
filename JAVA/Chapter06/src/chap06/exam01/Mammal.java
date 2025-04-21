package chap06.exam01;

// abstract 키워드가 있으면 추상 클래스 이다.
public abstract class Mammal {
	
	public String name;
	
	public Mammal(String name) { // 추상클래스는 오직 자식을 통해서만 객체화가 가능하다.
		this.name = name;
	}
	
	public void birth() {
		System.out.println(name+" 가 아이를 낳는다.");
	}
	
	public void eat() {
		System.out.println(name+" 가 젖을 먹인다.");
	 }

}
