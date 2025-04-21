package chap05.exam03;

public class Main {

	public static void main(String[] args) {
		
		MyCar car = new MyCar();
		car.start();
		System.out.println(car.run()+"km 로 달린다.");
		
		car.turbo = true;
		System.out.println(car.run()+"km 로 달린다.");
		car.stop();

	}

}
