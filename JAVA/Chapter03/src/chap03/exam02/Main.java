package chap03.exam02;

public class Main {

	public static void main(String[] args) {
		
		int scores[] = new int[10]; // 10개짜리 배열 생성
		System.out.println(scores.length);
		
		// scores 는 몇번부터 몇번까지 있을까?scores[0] ~ scores[9]
		// scores 0 번방에 100을 대입
		scores[0] = 100;
		// scores 1 번방에 50을 대입
		scores[1] = 50;
		// scores 2 번방에 70을 대입
		scores[2] = 70;
		// 3번방 부터 9번방 까지 100을 각각 넣기
		/*
		scores[3] = 100;
		scores[4] = 100;
		scores[5] = 100;
		scores[6] = 100;
		scores[7] = 100;
		scores[8] = 100;
		scores[9] = 100;
		*/
		
		for (int i = 3; i < scores.length; i++) {
			//System.out.println(i);
			scores[i] = 100;
		}
		
	}

}










