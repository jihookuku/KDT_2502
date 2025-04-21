package chap05.exam04;

public class Main {

	public static void main(String[] args) {
		
		// 다형성 활용 X -> 자식이 늘때 마다 변수도 계속 늘어난다.
		Child ch1 = new Child();		
		ChildTwo ch2 = new ChildTwo();		
		ChildThree ch3 = new ChildThree();		
		ChildFour ch4 = new ChildFour();
		
		ch1.useRoom();
		ch2.useRoom();
		ch3.useRoom();
		ch4.useRoom();
		
		// 다형성 사용 -> 부모형태의 변수에 자식들이 모두 사용 가능
		ParentHouse house = null;
		house = new Child();
		house.useRoom();
		
		house = new ChildTwo();
		house.useRoom();
		
		house = new ChildThree();
		house.useRoom();
		
		house = new ChildFour();
		house.useRoom();

	}

}










