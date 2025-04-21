package chap12.exam02;

public class Job extends Thread {

	@Override
	public void run() {
		
		for (int i = 1; i <= 10; i++) {
			System.out.println("work thread 가 할 일");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}

	}	

}
