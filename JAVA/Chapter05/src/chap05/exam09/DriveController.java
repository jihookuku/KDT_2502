package chap05.exam09;

public class DriveController {

	public static void main(String[] args) {
		
		Racer racer = new Racer();
		Car car = null; // 필드 다형성
		
		car = new Audi();
		System.out.println(racer.drive(car));
		
		car = new Benz();
		System.out.println(racer.drive(car));
		
		car = new Bmw();
		System.out.println(racer.drive(car));
		

	}

}
