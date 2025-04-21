package chap06.exam03;

public interface MouseEvent {
	
	public void click(int btn); // 인터페이스에서는 추상메서드가 기본메서드 이다.
	
	public void bdlClick(int btn); 
	
	public double[] move(); 
	
	// JDK 1.8 부터 가능한 것들
	public default void wheel(int i) {
		if (i ==1) {
			System.out.println("윗 방향으로 스크롤");
		}else {
			System.out.println("아랫 방향으로 스크롤");
		}
	}
	
	public static void setDpi(int dpi) {
		System.out.println("감도 : "+dpi);
	}

}
