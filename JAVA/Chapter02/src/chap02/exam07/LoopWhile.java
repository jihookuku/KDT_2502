package chap02.exam07;

public class LoopWhile {

	public static void main(String[] args) {
		
		int i = 1;
		
		while (true) {// 조건이 true 이면 false 가 될수 없기 때문에 영원히 반복된다.(무한루프)			
			System.out.println("i="+i);
			i++;
			if (i>10) {
				break;
			}
			
		}
		
		//unreachable code : 닿지 않는 코드
		// 해결방법 1 : 아래 코드를 지운다.
		// 해결방법 2 : 위의 while 문이 정지될수 있는 조건을 만들어 준다.
		int cup = 1;
		


	}

}
