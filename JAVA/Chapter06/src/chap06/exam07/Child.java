package chap06.exam07;

import chap06.exam03.MouseEvent;
import chap06.exam04.KeyEvent;

public interface Child extends KeyEvent, MouseEvent {
	
	public void textField(String msg);
	
	public void selectOne();
	
	public void checkOne();
	

}
