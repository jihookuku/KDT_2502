package chap02.exam02;

public class Two {

	public static void main(String[] args) {
		// % 나머지 연산
		// 두 수를 나눈 나머지를 반환 하는 연산자
		// % 연산은 홀수/짝수 또는 특정 배수 찾기에 자주 사용된다.
		System.out.println("5%2 = "+5%2);
		
		// 문자열 더하기(문자열 뒤에 무엇을 더하던지 뒤에 붙인다.)
		String str1 = "JDK"+8+0.65; // 문자열+숫자
		System.out.println(str1);
		String str2 = str1 + " 의 특징";
		System.out.println(str2); // 문자열 + 문자열
		
		String str3 = 8+0.65 + " JDK";
		System.out.println(str3);
		
		//80.65JDK 로 만들고 싶으면?
		String str4 =  ""+8+0.65 + " JDK";
		System.out.println(str4);

	}

}















