package chap12.exam10;

public class MainThread {

	public static void main(String[] args) throws InterruptedException {
		
		// 워크 스레드 생성
		Thread th = new WorkThread();
		th.setDaemon(true); // 데몬스레드로 전환
		th.start(); // 실행
		
		Thread.sleep(3000);//3초 기다렸다가

		System.out.println("메인 스레드 종료!");
		// 워크스레드는 메인스레드가 종료되어도 독자적으로 움직인다.
		// 데몬스레드는 메인스레드가 종료되면 같이 종료한다.

	}

}
