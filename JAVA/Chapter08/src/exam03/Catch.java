package exam03;

public class Catch {

	public static void main(String[] args) {
		
		String[] arr = new String[2];
		
		try {
			arr[0] = "1234";
			arr[1] = "123b";
			arr[2] = "12345"; // ArrayIndexOutOfBoundsException
			
			int val1 = Integer.parseInt(arr[0]);
			int val2 = Integer.parseInt(arr[1]);//NuberFormatException
		}catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("배열의 인덱스를 넘어섰습니다.");
		}catch (NumberFormatException e) {
			System.out.println("숫자만 입력이 가능 합니다.");
		}finally {
			System.out.println("끝!!");
		}
		

	}

}
