package exam03;

public class Multi {

	public static void main(String[] args) {
		
		String[] arr = new String[2];
		
		try {
			arr[0] = "1234";
			arr[1] = "123b";
			arr[2] = "12345"; // ArrayIndexOutOfBoundsException
			
			int val1 = Integer.parseInt(arr[0]);
			int val2 = Integer.parseInt(arr[1]);//NuberFormatException

		} catch (ArrayIndexOutOfBoundsException | NumberFormatException e) { // 1.7 부터 적용되는 multi catch
			System.out.println("배열의 크기나 입력데이터에 문자가 있는지 확인 하세요!");
		}finally {
			System.out.println("끝!!");
		}
		


	}

}
