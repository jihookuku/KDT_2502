package chap12.exam07;

public class MainThread {

	public static void main(String[] args) throws InterruptedException {
	
		System.out.println("1~100 까지 합은?");
		
		//work 스레드에게 계산하라고 시키고...
		OperThread oper = new OperThread();
		oper.start();
		
		//누구를 기다려?
		oper.join();
		
		// 나는 출력 한다.
		System.out.println("답 : "+oper.getSum());
	}

}
