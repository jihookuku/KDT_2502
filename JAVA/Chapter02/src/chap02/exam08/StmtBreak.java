package chap02.exam08;

public class StmtBreak {

	public static void main(String[] args) {
		
		// i 가 3 이면 for 문을 빠져나가도록 만드세요! 
		for (int i = 1; i <= 10; i++) {
			System.out.println(i);
			
			if (i==3) {
				break;
			}
			
		}

	}

}
