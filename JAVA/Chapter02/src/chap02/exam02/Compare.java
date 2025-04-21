package chap02.exam02;

public class Compare {

	public static void main(String[] args) {
		
		
		//대입 연산자
		int v1 = 1;
		double v2 = 1.0;
		int v3 = 4;
		String v4 = "JAVA";
		String v5 = new String("JAVA");
		
		// 비교연산(크다, 작다, 같다, 같지 않다.)
		System.out.println(v1 > v3);
		System.out.println(v1 != v3);
		System.out.println(v1 == v2);
		System.out.println(v4 == v5);
		// 문자열은 같은지 확인을 == 로 하면 안된다.
		System.out.println(v4.equals(v5));
		
		//논리 연산
		int val = 6;
		
		if (val>1 && val<7) {// && 는 모두 만족해야 하므로 7을 6으로 바꾸면 아래 결과가 나오지 않는다.
			System.out.println("val 은 1보다 크고 7보다 작은 수 입니다.");
		}
		
		if (val%5==0 || val%2==0) {// || 는 무엇 하나라도 만족하면 아래 결과가 나온다.
			System.out.println("val 은 5의 배수 또는 2의 배수 입니다.");
		}
		
		//로그인 과정은 AND 조건이다(ID 와 PW 를 모두 만족해야 하기 때문에...)


	}

}
















