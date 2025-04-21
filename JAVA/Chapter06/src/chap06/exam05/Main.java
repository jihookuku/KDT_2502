package chap06.exam05;

import chap06.exam03.MouseEvent;
import chap06.exam04.KeyEvent;
import chap06.exam04.Window;

public class Main {

	public static void main(String[] args) {
		
		//인터페이스 다형성
		Common comm = new CommonImpl();
		comm.test1();
		comm.test2();
	
		//Window 는 MouseEvent 와  KeyEvent 두개를 구현
		MouseEvent me = new Window(); // MouseEvent  를 오버라이드한 메서드만 사용 가능
		me.click(0);
		me.bdlClick(0);
		me.move();

		KeyEvent ke = new Window(); // KeyEvent  를 오버라이드한 메서드만 사용 가능
		ke.keyDown(0);
		ke.keyUp(0);

	}

}
