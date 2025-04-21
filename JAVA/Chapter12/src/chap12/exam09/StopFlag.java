package chap12.exam09;

public class StopFlag extends Thread{

	public boolean run = true;
	
	
	@Override
	public void run() {		
		while (run) {
			System.out.println("스레드 실행중...(자소서 작성중...)");
		}
		System.out.println("자소서 저장하고...");
		System.out.println("PC를 종료 한다.");

	}

	
	


}
