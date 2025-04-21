package chap12.exam02;

public class MainThread {

	public static void main(String[] args) {

		// 할일 생성
		Job job = new Job();
		// 워크스레드 생성(할일 넣어주기) X
		
		job.start();// 워크스레드 실행
		
		// 내가 할일 하기
		for (int i = 1; i <= 10; i++) {
			System.out.println("main thrad 가 할 일");
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				e.printStackTrace();
			}			
		}
		

	}

}
