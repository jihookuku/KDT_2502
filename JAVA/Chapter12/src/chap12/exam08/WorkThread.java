package chap12.exam08;

public class WorkThread extends Thread {

	private WorkObj obj;
	
	public WorkThread(WorkObj obj) {
		this.obj = obj;
	}

	@Override
	public void run() {
		
		for (int i = 0; i < 5; i++) {
			obj.work();
		}

	}
	
	


}
