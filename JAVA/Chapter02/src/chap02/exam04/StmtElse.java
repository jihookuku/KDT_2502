package chap02.exam04;

public class StmtElse {

	public static void main(String[] args) { // 이게 없으면 프로그램 실행이 안됨
		
		int box = 0;
		
		System.out.println("두부 가게에 간다.");
		/*
		if (box>0) {
			System.out.println("두부를 산다.");
		}
		
		if (box<1) { // 설정을 잘못하면 어느것도 실행되지 않는 상황이 발생할 수 있다.
			System.out.println("순두부를 산다.");
		}
		*/
		
		if (box>0) {
			System.out.println("두부를 산다.");
		} else {
			System.out.println("순두부를 산다.");
		}
		
		System.out.println("집에 온다.");


	}

}
