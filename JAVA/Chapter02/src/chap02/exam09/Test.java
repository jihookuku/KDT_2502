package chap02.exam09;

public class Test {

	public static void main(String[] args) {
		// 2단부터 9단까지 모두 출력해 보기
		for (int i = 2; i <= 9; i++) {			
			for (int j = 1; j <=9 ; j++) {
				System.out.println(i+" X "+j+" = "+i*j);
			}			
			System.out.println("============");
		}

	}

}
