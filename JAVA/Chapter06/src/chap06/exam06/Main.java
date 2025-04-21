package chap06.exam06;

import chap06.exam05.Common;
import chap06.exam05.CommonImpl;

public class Main {

	public static void main(String[] args) {
		
		// 1. 인터페이스는 객체화 되지 않는다.
		// 2. 클래스를 통해 구현해서 사용해야 한다.(클래스에 기생한다.)
		// 3. 만약 강제로 객체화 하려고 시도하면?
		//Common comm = new CommonImpl(); // 일반적인 객체화
		
		//익명객체 - 인터페이스를 구현해주는 클래스의 이름이 없다하여서...
		Common comm = new Common() {			
			@Override
			public void test2() {
				System.out.println("익명 객체의 test2");				
			}
			
			@Override
			public void test1() {
				System.out.println("익명 객체의 test1");			
			}
		};
		
		comm.test1();
		comm.test2();

	}

}
