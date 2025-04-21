package chap12.exam01;

public class Job implements Runnable {

	@Override
	public void run() { // 스레드가 해야 할 일
		
		for (int i = 1; i <= 10; i++) {
			System.out.println("work thread 가 해줬으면 하는 일");
			try {
				Thread.sleep(500); // 0.5 초간 쉰다.
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
