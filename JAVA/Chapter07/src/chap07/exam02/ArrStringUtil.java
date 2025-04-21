package chap07.exam02;

import java.util.Arrays;

public class ArrStringUtil {

	public static void main(String[] args) {
		
		String str = "abcdefg";
		
		String strResult;
		int intResult;
		char charResult;
		
		/*문자열이 문자 배열이기에 사용 가능한 기능들*/
		
		// 1. 문자열 길이
		intResult =  str.length();
		System.out.println(intResult);
		
		// 2. 특정 인덱스 문자 가져오기
		charResult = str.charAt(2);
		System.out.println(charResult);
		
		// 3. 문자열 -> 문자 배열
		char[] arr = str.toCharArray();
		
		for (char c : arr) {
			System.out.println(c);
		}
		
		// 문자 배열 -> 문자열?
		String newStr = new String(arr);
		System.out.println(newStr);
		System.out.println(Arrays.toString(arr));
		
		// 특정 문자가 몇번 인덱스에 있는지 확인(1개만 찾아 준다.)
		str = "abcdabcdabcd";
		intResult = str.indexOf("c");
		System.out.println("c 의 위치는? "+intResult);
		
		intResult = str.lastIndexOf("c");
		System.out.println("c 의 위치는? "+intResult);
		
		/* 모든 C 를 찾아낼 방법은?
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == 'c') {
				System.out.println("c 의 위치 : "+i);
			}
		}
		*/
		
		intResult = 0;
		while (intResult>-1) {
			intResult = str.indexOf("c", intResult);
			if (intResult>-1) {
				System.out.println("c 의 위치 : "+intResult);
				intResult++;
			}			
		}
		
		// 잘라내기
		str = "0123456789";
		// 1번 인덱스 부터 보여주고, 5번 인덱스 부터 버려라
		newStr = str.substring(1, 5);
		System.out.println(newStr);
		
		newStr  = str.substring(5); // 5번 인덱스 부터 보여줘라
		System.out.println(newStr);
		
		//특정 문자 기준으로 나누기
		str = "a/b/c/d/e/f/g";
		String[] array = str.split("/");
		System.out.println(array[2]);
		

	}

}





