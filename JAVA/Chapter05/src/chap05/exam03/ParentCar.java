package chap05.exam03;

public class ParentCar {
	
	public void start() {
		System.out.println("시동을 건다.");
	}
	
	public int run() {		
		return 50;		
	}
	
	public void stop() {
		System.out.println("멈춘다.");
	}
	
	// final 은 읽기 전용 이므로 수정하는 오버라이드는 불가능 하다.
	public final void test() {
		System.out.println("자동차 점검");
	}
	

}
