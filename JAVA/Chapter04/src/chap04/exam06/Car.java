package chap04.exam06;

public class Car {
	
	int gear = 0;
	boolean on = false;
	
	public Car() {// 생성자	(값을 초기화 해 준다.)
		gear = 1;
		on = false;
	}
	
	void start() {
		
		if (on == true) {
			System.out.println("시동이 이미 걸려 있습니다.");
		}else {
			System.out.println("시동이 걸렸습니다.");
			on = true;
		}
		
	}
	
	void change(int gear) {
		System.out.println(gear+" 단으로 기어가 변경 되었습니다.");
		this.gear = gear;// 이 클래스에 있는 gear = 받아온 gear
	}
	
}











