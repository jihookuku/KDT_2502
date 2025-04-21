package chap05.exam09;

public class Racer {

	// 매개변수 다형성 사용
	// 자동차 객체가 아무리 늘어나도 Car 를 상속받고 있다면 
	// 메서드를 추가하지 않아도 된다.
	public String drive(Car car) {
		return car.run();
	}

}
