package chap12.exam13;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallBlock {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		int n = Runtime.getRuntime().availableProcessors();
		ExecutorService pool = Executors.newFixedThreadPool(n);
				
		Callable<Integer> call = new Callable<Integer>() {			
			@Override
			public Integer call() throws Exception {
				int sum = 0;
				for (int i = 1; i <= 100; i++) {
					sum += i;					
				}
				System.out.println("계산 완료 : "+sum);
				return sum;
			}
		};
		
		System.out.println("1~100 까지의 합은?");
		Future<Integer> result = pool.submit(call); // blocking 기능 활용
		int dap = 0;
		dap = result.get(); // 실제적인 blocking 은 이걸 사용해야 일어남
		System.out.println("답 : "+dap);
		
		pool.shutdown();
		

	}

}
