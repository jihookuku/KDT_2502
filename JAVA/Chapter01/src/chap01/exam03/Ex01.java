package chap01.exam03;

public class Ex01 {

	public static void main(String[] args) {
		
		byte byteVal;
		char charVal;
		
		int intVal;
		long longVal;
		
		float floatVal;
		double doubleVal;
		
		//묵시적형변환 : 작 -> 큰 / 별 말 없이 이동한다.
		// byte < int
		byteVal = 10;
		intVal = byteVal;
		
		// char < int
		charVal ='가';
		intVal = charVal;
		System.out.println(intVal); // 아스키코드로 변환해서 보여준다.
		
		// int < long
		longVal = intVal;
		
		//float < double
		floatVal = 0.01f;
		doubleVal = floatVal;
		
		

	}

}








