package chap12.exam12;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallMain {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		// 1. 스레드풀 생성
		int n = Runtime.getRuntime().availableProcessors();
		ExecutorService pool = Executors.newFixedThreadPool(n);
		
		// 2. 할일 : 반환값이 있으면 Callable 활용
		Callable<String> call = new Callable<String>() {			
			@Override
			public String call() throws Exception {
				System.out.println("반환값이 있는 작업 실행");
				return "완료!";
			}
		}; 
		
		// 3. 반환이 필요한 작업 실행
		Future<String> result = pool.submit(call);
		System.out.println(result.get());
		
		pool.shutdown();// 모든 스레드가 나갈떄 까지 계속 기다림
		// awaitTermination 은 필수는 아니지만 만약을 위해 설정하는 것이 좋다.(API 에서도 권고)
		System.out.println("풀 종료");

	}

}
