package chap06.exam07;

public class Main {

	public static void main(String[] args) {
		
		Child ch = new ChildImpl();
		//KeyEvent
		ch.keyDown(0);
		ch.keyUp(0);
		
		//MouseEvent
		ch.click(0);
		ch.bdlClick(0);
		ch.move();
		
		//Child
		ch.checkOne();
		ch.selectOne();
		ch.textField("test");
		
		

	}

}
