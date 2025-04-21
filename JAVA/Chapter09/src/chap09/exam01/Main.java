package chap09.exam01;

public class Main {

	public static void main(String[] args) {
		
		Box box = new Box();
		box.setValue("1234");
		//박스에 넣긴 넣었는데... 무엇이 들었는지에 대한 정보가 없다.
		// 그래서 값을 가져올때 여러 확인이 필요하다.
		String val = (String) box.getValue();


	}

}
