package chap10.exam06;

public class Job {
	
	private String command;
	private String to;

	public Job(String command, String to) {//할일과 대상은 객체와 동시에 해 주고, 이후로는 변경할수 없도록(캡슐화 활용)
		this.command = command;
		this.to = to;
	}

	public String getCommand() {
		return command;
	}

	public String getTo() {
		return to;
	}	

}
