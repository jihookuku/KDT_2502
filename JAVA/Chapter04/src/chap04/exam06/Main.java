package chap04.exam06;

public class Main {

	public static void main(String[] args) {
		
		Car car = new Car();
		System.out.println("현재 기어 : "+car.gear);
		System.out.println("현재 시동상태 : "+car.on);
		
		car.start();
		car.change(4);
		System.out.println("현재 기어 : "+car.gear);

	}

}
