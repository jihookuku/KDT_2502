package chap05.exam08;

public class Racer {
	
	// 다형성을 사용하지 않으면 객체가 추가될수록 
	// 메서드를 계속 만들어줘야 한다.
	// 예 : Hyundai, Kia, Teslar 등이 추가되면 메서드 생성 필요
	
	public String run(Audi car) {
		return car.run();
	}
	
	public String run(Benz car) {
		return car.run();
	}
	
	public String run(Bmw car) {
		return car.run();
	}

}
