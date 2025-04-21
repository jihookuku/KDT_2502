package chap04.exam05;

public class Main {

	public static void main(String[] args) {
		
		// 1. 객체화를 위해 생성자 호출
		Puppy puppy = new Puppy("멍멍이", "집지키기");
		
		System.out.println("너의 이름은? "+puppy.name);
		System.out.println("너의 목적은? "+puppy.goal);
		
		// 오버로드를 통해 다양한 객체화를 손쉽게 할 수 있다.
		Puppy p2 = new Puppy();
		Puppy p3 = new Puppy("누렁이");
		
		//String str = new 

	}

}
