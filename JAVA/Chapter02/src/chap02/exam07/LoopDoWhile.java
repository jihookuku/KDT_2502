package chap02.exam07;

public class LoopDoWhile {

	public static void main(String[] args) {
		
		int a = 11;
		
		while (a<10) { // a 가 10보다 작은지 확인
			a++;// 작으면 증가
		}
		System.out.println("a="+a);
		
		
		int b = 11;
		
		// do...while 은 조건이 맞지 않더라도 한번은 실행되어야 할때 사용 한다.(예:버스카드)
		do {
			b++; // 일단 b 를 증가
		} while (b<10); // 이후 b가 10보다 작으면 다음을 실행
		System.out.println("b="+b);

	}

}
