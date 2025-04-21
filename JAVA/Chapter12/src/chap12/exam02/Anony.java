package chap12.exam02;

public class Anony {

	public static void main(String[] args) {
		
		// 상속하는 클래스를 익명객체로 만들기
		Thread thread = new Thread() {

			@Override
			public void run() {
				for (int i = 1; i <= 10; i++) {
					System.out.println("work thread 가 하는 일...");
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			
		};
		thread.start();
		
		// 내가 할 일
		for (int i = 1; i <= 10; i++) {
			System.out.println("matin thread 가 하는 일...");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
