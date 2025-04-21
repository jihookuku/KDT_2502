package chap05.exam02;

public class Child extends Parent {

	public Child() {
		super(); // 부모생성자(자식생성자 실행 전에 실행 - 생략가능)
		System.out.println("자식 생성자");
	}

}
