package chap06.exam02;

public class Concrete extends Abs {

	// Abs 를 상속받으면 추상메서드는 강제 오버라이드 된다.
	@Override
	public void must1() {
		System.out.println("꼭 만들어줘야 할 메서드 1");
	}

	@Override
	public void must2() {
		System.out.println("꼭 만들어줘야 할 메서드 2");
	}
	
	public void child() {
		System.out.println("자식의 메서드");
	}

}
