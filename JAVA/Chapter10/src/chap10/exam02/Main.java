package chap10.exam02;

import java.util.ArrayList;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) {
		
		// 1. ArrayList 와 Linked 준비
		ArrayList<String> arr = new ArrayList<String>();
		LinkedList<String> lnk = new LinkedList<String>();
				
		// 2. 경기 조건을 생성
		for (int i = 1; i <= 100; i++) {
			arr.add("data");
			lnk.add("data");
		}
				
		long startTime = 0;
		long endTime = 0;
		
		// 3. 시작시간 측정
		startTime = System.currentTimeMillis(); // 현재 시간을 1/1000 초로 계산해서 반환
		
		// 4. 달리기 시작
		for (int i = 1; i <= 1000000; i++) {
			lnk.add(55, "add data");
		}
		
		// 5. 도착시간 측정
		endTime = System.currentTimeMillis();
		
		// 6. 도착시간 - 시작시간 = 걸린시간
		System.out.println("Lnk 걸린시간 : "+(endTime-startTime)+" ms");
		
		
		// 3. 시작시간 측정
		startTime = System.currentTimeMillis(); // 현재 시간을 1/1000 초로 계산해서 반환
		
		// 4. 달리기 시작
		for (int i = 1; i <= 1000000; i++) {
			arr.add(55, "add data");
		}
		
		// 5. 도착시간 측정
		endTime = System.currentTimeMillis();
		
		// 6. 도착시간 - 시작시간 = 걸린시간
		System.out.println("Arr 걸린시간 : "+(endTime-startTime)+" ms");

	}

}




