package chap12.exam01;

public class Anony {

	public static void main(String[] args) {
		// 익명 객체로 스레드 돌리기
		
		Thread thread = new Thread(new Runnable() {			
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
		}); // 워크 스레드 생성(나를 복제 하는 것)
		thread.start();//스레드 실행
		
		
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
