package chap12.exam05;

public class Main {
	
	private static Thread.State state;

	public static void main(String[] args) throws InterruptedException {
		
		// 1. 워크스레드 생성
		WorkThread work = new WorkThread();
		
		// 2. 상태 확인
		state = work.getState();
		System.out.println("Thread state : "+state);
		
		// 3. 스레드 시작
		work.start();
		
		// 4. 지속적으로 감시
		while(true) {
			state = work.getState();
			System.out.println("Thread state : "+state);			
			//Thread.sleep(10);			
			// 5. 워크 스레드가 종료상태면 감시 중지
			if(state == Thread.State.TERMINATED) {
				break;
			}			
		}

	}

}
