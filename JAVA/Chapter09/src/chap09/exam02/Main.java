package chap09.exam02;

public class Main {

	public static void main(String[] args) {
		//제너릭에는 클래스형태 타입만 가능
		Box<Integer> box = new Box<Integer>();
		box.setValue(123);
		
		int val = box.getValue();//아무 과정없이 바로 확인가능
		System.out.println(val);
				

	}

}
