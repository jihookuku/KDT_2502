package chap12.exam12;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {

	public static void main(String[] args) {
		
		int n = Runtime.getRuntime().availableProcessors();
		ExecutorService pool = Executors.newFixedThreadPool(n);
		
		Runnable runn = new Runnable() {			
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName()+"Thread Pool");				
			}
		};
		
		for (int i = 0; i < 10; i++) {
			pool.execute(runn);
		}
		
		pool.shutdown();
		System.out.println("풀 종료");
		

	}

}
