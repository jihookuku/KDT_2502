package chap02.exam03;

public class Main {

	public static void main(String[] args) {
		
		int score = 75;		
		// 조건에 따라서 대입되는 값이 달라질때 유용하다.
		// char grade = score > 90 ? 'A' : 'B';
		// 90점 초과는 A, 80점 초과는 B, 나머지는 C
		char grade = score > 90 ? 'A' : score > 80 ? 'B' : 'C';
		
		System.out.println(grade);
		
	}

}
