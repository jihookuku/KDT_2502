package chap12.exam05;

public class WorkThread extends Thread{

	@Override
	public void run() {
		
		long cnt = 0;
		// 일하고 -> 1.5초 쉬고 -> 또 일하고
		
		for (int i = 0; i < 1000000000; i++) {
			cnt++;
		}
		
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		for (int i = 0; i < 1000000000; i++) {
			cnt++;
		}
		

	}

}
