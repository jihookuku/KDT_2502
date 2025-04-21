package chap03.exam03;

public class Main {

	public static void main(String[] args) {
		
		int[] score = new int[10];
		// socre 안에 값을 10씩 넣어주자
		/*
		score[0] = 10;
		score[1] = 10;
		score[2] = 10;
		score[3] = 10;
		score[4] = 10;
		score[5] = 10;
		score[6] = 10;
		score[7] = 10;
		score[8] = 10;
		score[9] = 10;
		*/
		
		for (int i = 0; i < score.length; i++) {
			score[i] = (i+1)*10;
		}
		
		// 0번방에 있는 값 호출
		System.out.println(score[0]);
		
		// 5번방에 있는 값 호출
		System.out.println(score[5]);
		
		// 9번방에 있는 값 호출
		System.out.println(score[9]);

		/* 0번방 부터 9번방까지 모두 출력
		System.out.println(score[0]);
		System.out.println(score[1]);
		System.out.println(score[2]);
		System.out.println(score[3]);
		System.out.println(score[4]);
		System.out.println(score[5]);
		System.out.println(score[6]);
		System.out.println(score[7]);
		System.out.println(score[8]);
		System.out.println(score[9]);
		*/
		for (int i = 0; i < score.length; i++) {
			System.out.println(score[i]);
		}
		
	}

}











