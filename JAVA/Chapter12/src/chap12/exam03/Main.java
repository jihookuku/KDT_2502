package chap12.exam03;

public class Main {

	public static void main(String[] args) {
		
		WorkThread thA = new WorkThread();
		thA.start();
		
		WorkThread thB = new WorkThread();
		thB.start();
		
		WorkThread thC = new WorkThread();
		thC.setName("막내 스레드");
		thC.start();
		
	


	}

}
