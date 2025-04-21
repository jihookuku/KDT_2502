package chap12.exam12;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class RunnMain {

	public static void main(String[] args) throws InterruptedException {
		
		// 1. 스레드풀 생성
		int n = Runtime.getRuntime().availableProcessors();
		ExecutorService pool = Executors.newFixedThreadPool(n);

		// 2. 할일 명시 : 반환값이 없으면 Runnable 활용
		Runnable runn = new Runnable() {			
			@Override
			public void run() {
				System.out.println("반환할 필요가 없는 작업 실행");				
			}
		};
		
		// 3. 반환할 필요가 없는 작업 실행
		pool.execute(runn);
		
		// 4. 스레드풀 종료
		pool.shutdown(); // 모든 스레드가 종료될때 까지 기다린다.
		// 하지만 안나가는 사람도 있으니 일정시간을 주고 이후 닫는다.
		boolean end = pool.awaitTermination(1L, TimeUnit.SECONDS);
		System.out.println("평화적으로 종료 ? "+end);

	}

}
