package chap12.exam04;

public class User2 extends Thread{
	
	private Computer com;

	public User2(Computer com) {
		setName("User 2");
		this.com = com;
	}

	@Override
	public void run() {
		com.setScore(100); // 게임을 해서 100점을 만든다.
	}
	
	

}
