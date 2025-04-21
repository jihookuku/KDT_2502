package chap04.exam05;

public class Puppy {
	
	String name; //4. 클래스가 끝날때 까지 게속 저장이 가능
	String goal;

	//String name; // 당연하게 같은 이름의 무언가가 있으면 안된다.
	
	
	//overload : 과적의 뜻이 있다.(정해진 기준을 넘어서 무언가를 담는 것)
	// 프로그램에서의 과적이란? 같은 이름으로 1개 이상 허용해 주는 것
	
	public Puppy(String name, String goal) {// 생성자(같은이름으로 존재하면 안된다.)
		// 2. name 과 goal 은 생성자 번위를 벗어날 수 없다.
		this.name = name;
		// 3.그래서  '이'클래스에 있는 변수에 받아온 변수를 대입해 준다.
		this.goal = goal;
	}
	
	//오버로드 활용하여 같은 이름으로 생성자를 만들었다.(매개변수의 갯수와 타입은 달라야 함)
	public Puppy(String name) { 
		this.name = name;
	}
	
	public Puppy() {
		
	}

}





