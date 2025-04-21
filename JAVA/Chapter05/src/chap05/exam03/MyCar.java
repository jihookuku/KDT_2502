package chap05.exam03;

public class MyCar extends ParentCar {

	/* 오버라이드 사용방식 1 - 완전히 고친다.
	@Override
	public int run() {
		return 150;
	}
	*/
	
	// 오버라이드 사용방식 2 - 부모 메서드 활용
	boolean turbo = false;
	
	@Override
	public int run() {
		if (turbo==false) {
			return super.run();
		} else {
			return super.run()*3;
		}		
	}	
	
	
	


}
