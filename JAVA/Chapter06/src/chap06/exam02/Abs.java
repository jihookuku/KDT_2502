package chap06.exam02;

public abstract class Abs {
	
	// 꼭 만들어야 하는 메서드는 추상 메서드로 선언
	public abstract void must1();
	
	public abstract void must2();
	
	public void prarent() {
		System.out.println("기본 메서드");
	}

}
