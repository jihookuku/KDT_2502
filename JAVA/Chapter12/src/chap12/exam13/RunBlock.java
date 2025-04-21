package chap12.exam13;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class RunBlock {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		int n = Runtime.getRuntime().availableProcessors();
		ExecutorService pool = Executors.newFixedThreadPool(n);
		
		Runnable runn = new Runnable() {			
			@Override
			public void run() {
				int sum = 0;
				for (int i = 1; i <= 100; i++) {
					sum += i;
				}
				System.out.println("답 : "+sum);
			}
		};
		
		//pool.execute(runn);//Runnable 은 submit() 을 쓸 수 없으므로 blocking 을 활용 할 수 없다.
		Future<?> future = pool.submit(runn); // 그래서 Runnable 도 submit 을 사용할수 있게 해주었다.
		future.get();
		System.out.println("제출 시간이 초과 되었습니다.");
		
		pool.shutdown();
		

	}

}
