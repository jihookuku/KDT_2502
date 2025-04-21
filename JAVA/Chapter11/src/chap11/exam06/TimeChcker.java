package chap11.exam06;

public class TimeChcker {
	
	private long start = 0;
	private long end = 0;
	
	public void start() {
		start = System.currentTimeMillis();
	}
	
	public String end() {
		end = System.currentTimeMillis();
		return "걸린시간 : "+(end-start)+"ms";
	}
	

}
