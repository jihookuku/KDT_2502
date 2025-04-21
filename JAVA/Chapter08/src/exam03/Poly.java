package exam03;

public class Poly {

	public static void main(String[] args) {
		
		String[] arr = new String[2];
				
		try {
			arr[0] = "1234";
			arr[1] = "123b";
			arr[2] = "12345"; // ArrayIndexOutOfBoundsException
			
			int val1 = Integer.parseInt(arr[0]);
			int val2 = Integer.parseInt(arr[1]);//NuberFormatException			
		} catch (Exception e) { // 다형성을 활용 하여 Exception 의 자식들은 발생하면 무조건 이쪽으로 모인다.
			System.out.println("데이터 입력이 잘못되었습니다. 다시 시도해 주세요!");
			//System.out.println(e.toString()); // 예외에 대한 간단한 정보
			e.printStackTrace();//상세정보(개발이 끝나고 나면 다 지워줘야 한다.)
		}



	}

}
