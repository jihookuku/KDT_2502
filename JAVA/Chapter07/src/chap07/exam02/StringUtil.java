package chap07.exam02;

public class StringUtil {

	public static void main(String[] args) {
		
		String str = "abcdefg";
		
		String strResult;
		int intResult;
		boolean booleanResult;
		
		/*String class 에서 제공해 주는 자주 사용하는 메서드*/
		
		// 1. 문자열 비교		
		booleanResult =  str.equals("abc");
		System.out.println(booleanResult);
		
		str = "[img]uploadFile.png";
		intResult=str.compareTo("[img]uploadFile.jpg");// 같으면 0, 다르면? 6
		// p 와 j 가 다르므로 두개의 아스키코드 값을 뺀다.
		// p(112) - j(106) = 6 
		System.out.println(intResult);
		
		// 2. 특정 문자열 포함 여부
		booleanResult = str.contains("png");
		System.out.println(booleanResult);
		
		// 3. 문자열 교체
		String newStr = str.replace("png", "JPEG");
		System.out.println(str+" => "+newStr);
		
		// 4. 앞뒤 공백 제거
		str = " 가나다라마바사 ";
		newStr = str.trim();
		System.out.println(str);
		System.out.println(newStr);
		
		// 5. 문자열의 시작과 끝 찾기
		str = "[img]uploadFile.png";
		//... 로 시작하는가?
		booleanResult = str.startsWith("[img]");
		System.out.println(booleanResult);
		
		//... 로 끝나는가?(파일 확장자 검사시 많이 활용)
		booleanResult = str.endsWith(".png");
		System.out.println(booleanResult);
		
		// 특정문자 반복		
		strResult = "*".repeat(4);
		System.out.println(strResult);
		
		
	}

}
