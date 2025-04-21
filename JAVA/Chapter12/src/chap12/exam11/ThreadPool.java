package chap12.exam11;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {

	public static void main(String[] args) {

		int n = Runtime.getRuntime().availableProcessors();
		System.out.println("사용 가능 메인 스레드 : "+n);
		
		// 스레드 풀 만드는 전략1
		// 손님이 오면 스레드를 그때 만든다.
		// 반납 받은게 있으면 그것을 빌려준다.
		// 받납후 60초동안 아무도 안빌려가면 폐기한다.
		ExecutorService pool1 = Executors.newCachedThreadPool();
		
		
		// 스레드 풀 만드는 전략2
		// 미리 n 개를 준비해 놓는다.
		// 모자라면 만들고, 있으면 빌려준다.
		// 받납후 60초동안 아무도 안빌려가면 폐기한다.(하지만 n 개는 남겨놓는다.)
		ExecutorService pool2 = Executors.newFixedThreadPool(n);
		
	}

}









