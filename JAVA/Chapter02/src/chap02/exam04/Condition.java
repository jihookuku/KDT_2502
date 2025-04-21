package chap02.exam04;

public class Condition {

	public static void main(String[] args) {
		// if 문은 () 안에 조건이 참(true) 이어야만 실행 된다.
		if (true) {
			System.out.println("무조건 실행이 된다.");
		}
		
		if (false) { // Dead Code : 실행되지 않을 코드 -> 비효율적이라서 알려줌
			System.out.println("무조건 실행되지 않는다.");
		}
		
		System.out.println();
		
		int box = 1;
		
		System.out.println("두부가게에 간다.");
		
		if (box>0) {
			System.out.println("두부를 산다.");
		}
		
		System.out.println("집에 온다.");
		
		
		
		
		
		
		

	}

}
