package chap01.exam04;

public class MethodList {
	
	// 매개변수 : O , 반환값 : O
	String toaster(String bread) {
		System.out.println("빵 굽기");
		return "구워진 빵";
	}
	
	// 매개변수 : O , 반환값 : X
	void 저금통(int coin){
		System.out.println(coin+" 을 저장하다.");
	}
		
	// 매개변수 : X , 반환값 : O
	String 번호표기기(){
		return "번호표";
	}
		
	// 매개변수 : X , 반환값 : X
	void 호출벨() {
		System.out.println("호출벨 울림");
	}
	
	

}
