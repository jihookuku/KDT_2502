package exam01;

public class ClassCastException {

	public static void main(String[] args) {
		// ClassCastException : 부모형태로 들어갔던 자식이 자식형태로 되돌아갈때 잘못 찾아간 경우
		Object val = 1234; // Integer
		int su = (int) val;
		System.out.println(su);
		
		String str = (String) val; // int 였던 값이 String 형태로 되돌아 가려고 해서 발생

	}

}
