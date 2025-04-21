package chap04.exam08;

public class Inner { // 동일 클래스에 일반 멤버와 정적멤보가 혼재되어 있을 경우

	public static void main(String[] args) {
		
		// 1. static 에서 static 을 부를때
		st_msg("Hello Static member");
		
		// 2. static 에서 일반 멤버를 부를때
		// 같은 클래스라 하더라도 영역이 다르면 다른 클래스에서 불러오듯이 해야 한다.
		Inner inner = new Inner();
		inner.h_msg("Hello, member");

	}
	
	static void st_msg(String msg) {
		System.out.println("static memeber msg : "+msg);
	}
	
	void h_msg(String msg) {
		// 3. 일반멤버에서 static 멤버를 부를 때
		Inner.st_msg("안녕하세요, 정적멤버");
		System.out.println("memeber msg : "+msg);
	}

}



