package chap12.exam04;

public class User1 extends Thread{
	
	private Computer com;

	public User1(Computer com) {
		setName("User 1");
		this.com = com;
	}

	@Override
	public void run() {
		com.setScore(500); // 게임을 해서 500점을 만든다.
	}
	
	

}
