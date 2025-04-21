package chap07.exam01;

public class Main {

	public static void main(String[] args) {
		
		// 문자열을 만드는 방법
		
		String str = "abcdefg"; //변수 선언하듯이 할당하는 방법
		
		String str2 = new String("abcdefg");
		
		char[] alphabet = {'a','b','c','d','e','f','g'};
		String str3 = new String(alphabet);
		
		System.out.println(str);
		System.out.println(str2);
		System.out.println(str3);


	}

}
