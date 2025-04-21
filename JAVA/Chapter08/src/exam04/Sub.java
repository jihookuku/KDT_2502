package exam04;

public class Sub {
	
	void method1() throws NumberFormatException{
		method2();
	}
	
	private void method2() throws NumberFormatException{
		//예외를 전가하고 싶을 경우...
		Integer.parseInt("a1234");
		
	}

}
