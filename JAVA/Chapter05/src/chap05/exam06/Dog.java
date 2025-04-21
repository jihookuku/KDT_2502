package chap05.exam06;

public class Dog extends Mammal {
	
	public void bark() {
		System.out.println("멍멍하고 짖는다.");
	}

	@Override
	public void birth() {
		System.out.println("새끼를 3마리 낳는다.");
	}
	
	

}
