package chap02.exam06;

public class LoopFor {

	public static void main(String[] args) {
		
		// 시작값; 조건; 증감
		// 물 10잔 떠오기
		/*
		for (int cup = 1; cup <= 10; cup++) {
			System.out.println("물 "+cup+" 잔째 떠오기");
		}
		*/
		
		// 커피 10잔 타오기(물한잔당 믹스 2개)
		for (int cup = 1; cup <= 10; cup++) {
			System.out.println("물 "+cup+" 잔째 떠오기");
			for (int mix = 1; mix <= 2; mix++) {
				System.out.println("믹스"+mix+" 개 넣기");
			}
		}


	}

}
