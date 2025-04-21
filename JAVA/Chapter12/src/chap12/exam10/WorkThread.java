package chap12.exam10;

public class WorkThread extends Thread {

	@Override
	public void run() {
		
		while (true) {
			try {
				Thread.sleep(500);
				System.out.println("워크 스레드 실행 중...");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}

	}

}
