package chap03.exam04;

public class Main {

	public static void main(String[] args) {
		
		// arr 아파트: 2개층 3개호 - 선언과 동시에 값을 넣는 방식
		int[][] arr= {
			{00,01,02,03},
			{10,11,12,13}
		};
		
		// royal 아파트 : 4개층 4개호
		String[][] royal = new String[4][4];//층,호
		royal[0][0] = "0층 0호";	//값을 넣을 때
		//System.out.println(royal[0][0]);//값을 호출할 때
		
		// null <- 값의 부재, 0 과 "" 와의 차이는?
		for (int i = 0; i < royal.length; i++) { // 층 수			
			for (int j = 0; j < royal[i].length; j++) {//특정층의 호 갯수
				
				if (royal[i][j] == null) {//만약 해당 층, 호가 null 이라면...
					royal[i][j] = i+"층 "+j+"호";
				}				
				
				System.out.println(royal[i][j]);	
			}
			System.out.println();
		}
		
		

	}

}
