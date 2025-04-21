package chap12.exam09;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		/* stop flag 활용
		StopFlag flag = new StopFlag();
		flag.start();
		Thread.sleep(1000);
		//flag.stop();// 자소서 저장과 PC 종료가 불가능 하다.
		flag.run = false;
		*/
		
		Thread thread = new Inter();
		thread.start();
		Thread.sleep(1000);
		thread.interrupt();// 강제 인터럽트 익셉션 발생

	}

}
