package chap12.exam08;

public class Main {

	public static void main(String[] args) {
		
		WorkObj obj = new WorkObj();
		Thread th1 = new WorkThread(obj);
		Thread th2 = new WorkThread(obj);
		th1.start();
		th2.start();
		

	}

}
