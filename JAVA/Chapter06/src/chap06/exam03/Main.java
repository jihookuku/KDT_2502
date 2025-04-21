package chap06.exam03;

public class Main {

	public static void main(String[] args) {
		
		// 인터페이스는 객체화 되지 않는다.
		// 구현받은 클래스를 객체화 하여 사용 한다.
		Window win = new Window();
		win.click(1);
		win.bdlClick(1);
		win.move();
		
		win.wheel(1);
		MouseEvent.setDpi(300);

	}

}
