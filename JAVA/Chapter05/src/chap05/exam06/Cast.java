package chap05.exam06;

public class Cast {

	public static void main(String[] args) {
		
		Mammal mal = null;
		
		mal = new Dog();
		mal.birth(); // 오버라이드 한 메서드
		mal.eat(); // 부모 메서드
		//mal.bark(); // 본인의 고유 메서드는 사용 안됨
		
		// bark() 를 사용하고 싶다면 Casting 을 해야 한다.
		Dog dog = (Dog) mal;
		dog.bark();
		
		// Dog 이었던 클래스가 Cat 형태로 되돌아 가려고 해서 생긴 예외
		//Cat cat = (Cat) mal;
		//cat.mew(); // ClassCastException
		
		// 방지하는 방법 - 맞는지 먼저 확인
		if (mal instanceof Cat) { // mal 이 Cat 의 형태인지 묻는다.(true|false)
			Cat cat = (Cat) mal;
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		


	}

}
