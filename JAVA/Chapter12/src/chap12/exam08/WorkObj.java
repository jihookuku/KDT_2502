package chap12.exam08;

public class WorkObj {
	
	// wait(), notify(), notifyAll() 은 synchronized 안에서 해야한다.
	// 한꺼번에 들어가서 쉬게되면 모두 쉬어버리는 상황이 생길수도 있으므로...
	public synchronized void work() {
		
		System.out.println(Thread.currentThread().getName()+" 이 실행됨");
		notify();		// 먼저 깨우고
		try {
			wait();	// 내가 쉰다.
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
