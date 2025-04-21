package chap12.exam01;

public class MainThread {

	public static void main(String[] args) { // main() 은 main thread 를 호출하는 메서드였다.
		
		
		// 해야할 일이 담겨 있다.
		Job job = new Job();
		
		// 쓰레드를 생성(해야할 일을 넣어준다.)
		Thread thread = new Thread(job);
		
		// 쓰레드를 시작
		thread.start();		
		
		for (int i = 1; i <= 10; i++) {
			System.out.println("main thread 가 하는 일");
			try {
				Thread.sleep(500); // 0.5 초간 쉰다.
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}


	}

}
