package chap01.exam03;

public class Ex02 {

	public static void main(String[] args) {
		
		// 명시적형변환(Casting) 큰 -> 작
		char charVal;
		int intVal;
		long longVal;
		float floatVal;
		double doubleVal;
		
		//intVal -> charVal
		intVal = 44032;
		charVal = (char) intVal;//명시적 형변환
		
		longVal = 500;
		// longVal -> intVal;
		intVal = (int) longVal;
		
		doubleVal = 3.14;
		// doubleVal -> floatVal;
		floatVal = (float) doubleVal;
		
		


	}

}
