package chap03.exam05;

public class Main {

	public static void main(String[] args) {
		
		String[][][] royal = new String[4][4][3];
		// 층수는 얼마나 되나?
		System.out.println("층 수 : "+royal.length);
		// 한 층의 호수는 얼마나 되나?
		System.out.println("0층의 호수 : "+royal[0].length);
		// 특정 호의 방 수는 얼마나 되나?
		System.out.println("0층 0호의 방 개수 : "+royal[0][0].length);
		
		// 2층 3호 2번 방은 "철수의 방"
		royal[2][3][2] = "철수의 방";
		
		// 0층 0호 0번 방은 "영희의 방"
		royal[0][0][0] = "영희의 방";
		
		for (int i = 0; i < royal.length; i++) {
			for (int j = 0; j < royal[i].length; j++) {
				for (int k = 0; k < royal[i][j].length; k++) {
					
					if (royal[i][j][k] == null) {
						royal[i][j][k] = "공실";
					}
										
					System.out.println(royal[i][j][k]);
				}
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
