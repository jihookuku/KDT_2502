package chap12.exam07;

public class OperThread extends Thread {

	private int sum = 0;
	
	@Override
	public void run() {		
		for (int i = 1; i <= 100; i++) {
			sum += i;
		}
	}

	public int getSum() {
		return sum;
	}
	
}
