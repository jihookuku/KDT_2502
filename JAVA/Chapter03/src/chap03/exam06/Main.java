package chap03.exam06;

public class Main {

	public static void main(String[] args) {
		
		int[] score = {95, 75, 84, 35, 88};//0,1,2,3,4
		
		/* for 문으로 score 에 있는 값을 출력 하세요
		System.out.println(score[0]);
		System.out.println(score[1]);
		System.out.println(score[2]);
		System.out.println(score[3]);
		System.out.println(score[4]);
		*/
		// 일반 for -> 배열의 시작과 끝을 스스로 정할 수 있다.
		for (int i = 0; i < score.length; i++) {
			System.out.println(score[i]);
		}
		System.out.println();
		
		// 향상된 for -> 왼쪽에 있는 배열의 값을 처음부터 끝까지 모두 뽑아낸다.
		for (int s : score) {// score 에 있는 값들을 하나씩 뽑아서 앞에있는 변수에 넣는다.
			System.out.println(s);
		}
		
	}

}














