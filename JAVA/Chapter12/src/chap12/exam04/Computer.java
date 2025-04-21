package chap12.exam04;

public class Computer {
	
	private int score;

	// 누군가 컴퓨터를 사용할 경우 모두 사용할 떄까지 Lock 하는 기능을 넣자
	/* 1. 동기화 메서드 방식 : 이 메서드에는 하나의 스레드만 들어갈 수 있다.
	public synchronized void setScore(int score) {
		this.score = score; // 게임해서 점수를 만든다.
		try {
			Thread.sleep(2000); // 2초 동안 잠깐 쉰다.
			System.out.println(Thread.currentThread().getName()+" : "+this.score);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	*/
	
	// 2. 동기화 블록 방식 : 메서드 까지는 들어올수 있으나 특정 영역은 다른 스레드가 들어오지 못함
	public void setScore(int score) {		
		synchronized (this) {
			this.score = score; // 게임해서 점수를 만든다.
			try {
				Thread.sleep(2000); // 2초 동안 잠깐 쉰다.
				System.out.println(Thread.currentThread().getName()+" : "+this.score);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}			
		}
	}
	
}
