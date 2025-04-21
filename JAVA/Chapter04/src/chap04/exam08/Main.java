package chap04.exam08;

public class Main {

	public static void main(String[] args) {
		
		Sub sub = new Sub();
		int result = 0;
		//일반멤버 : 원본에서 객체화 한다음 접근해야 한다.
		result = sub.multi(6, 2);
		System.out.println(result);
		
		//정적(static) 멤버 : 원본에 접근해야 한다.
		result = Sub.minus(10, 2);
		System.out.println(result);
		
		// 객체로도 정적멤버를 문제없이 호출 할순 있다.
		// 하지만 권고하지 않는다.
		result = sub.plus(4, 4);
		System.out.println(result);
		
		// member : 수정하면 특정 객체에서만 볼 수 있다.
		Sub sub2 = new Sub();
		sub.field = 1000;
		System.out.println(sub.field+" / "+sub2.field);
				
		// static member : 수정하면 모두가 볼수 있다.
		sub.sField = 2000;
		System.out.println(sub.sField+" / "+sub2.sField);
		
		
		
		
		
		
		
		
		
		
		
	}

}
