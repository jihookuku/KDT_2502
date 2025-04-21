package chap10.exam06;

import java.util.LinkedList;
import java.util.Queue;

public class JobQueue {

	public static void main(String[] args) {
		
		//QUeue 는 인터페이스만 제공된다.(실제 구현은 LinkedList)
		Queue<Job> queue = new LinkedList<Job>();
		
		// 데이터 입력
		queue.offer(new Job("send SMS", "Alice"));
		queue.offer(new Job("send Mail", "Brayan"));
		queue.offer(new Job("send SMS", "Criss"));
		queue.offer(new Job("send Talk", "Deniel"));
		queue.offer(new Job("send Mail", "Erick"));
		
		Job job = null;
		while (!queue.isEmpty()) {
			job = queue.poll();
			System.out.println(job.getCommand()+" to "+job.getTo());
			System.out.println("남은 작업 수 : "+queue.size());
		}


	}

}







