package exam01;

public class NumberFormatException {

	public static void main(String[] args) {
		//NumberFormatException : 숫자형태가 아닌 문자를 숫자로 변경하려고 할 때
		String value = "1234";
		int val = Integer.parseInt(value);
		System.out.println(val+1); // 문자였다면 12341 이 되었을 것
		
		// "1234" -> 1234
		// "123b" -> 123b?
		value = "123b";
		val = Integer.parseInt(value);
		
	}

}
