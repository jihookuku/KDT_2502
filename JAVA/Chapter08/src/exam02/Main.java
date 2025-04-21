package exam02;

public class Main {

	public static void main(String[] args) {
		
		String data1 = "1234";
		String data2 = "5678";//asdf
		
		try {
			int val1 = Integer.parseInt(data1);
			int val2 = Integer.parseInt(data2);
			System.out.println("result="+(val1+val2));
		} catch (NumberFormatException e) {
			System.out.println("숫자로만 입력해야 합니다.");
		}finally {
			System.out.println(data1);
			System.out.println(data2);			
		}

	}

}
