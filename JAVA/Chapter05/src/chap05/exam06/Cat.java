package chap05.exam06;

public class Cat extends Mammal {
	
	public void mew() {
		System.out.println("야옹 하고 운다.");
	}

	@Override
	public void birth() {
		System.out.println("새끼를 5마리 낳는다.");
	}
	
	

}
