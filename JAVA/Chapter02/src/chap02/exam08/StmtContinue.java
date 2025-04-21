package chap02.exam08;

public class StmtContinue {

	public static void main(String[] args) {
		
		for (int i = 1; i <= 10; i++) {
			
			if (i==3) {
				continue;
			}
			
			System.out.println(i);// 3만 빼고 출력
		}
		

	}

}
