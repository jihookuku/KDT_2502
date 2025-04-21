package chap12.exam06;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		WorkThread th1 = new WorkThread();
		th1.setName("A");
		
		WorkThread th2 = new WorkThread();
		th2.setName("B");
		
		th1.start();
		th2.start();
		
		th1.yield = true;
		Thread.sleep(500);
		
		th1.yield = false;
		th2.yield = true;
		Thread.sleep(500);
		
		th1.stop = true;
		th2.stop = true;
		
	}

}
