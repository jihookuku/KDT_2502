package chap01.exam04;

public class Main {

	public static void main(String[] args) {
		
		String 빨래감 = "옷";
		String basket = 세탁기(빨래감); // 반환값이 있을경우 받아줄 변수가 필요하다.
		System.out.println("세탁된 "+basket);
		
	}
	
	static String 세탁기(String 빨래감){
		System.out.println(빨래감+" 을 세탁하고");
		System.out.println(빨래감+" 을 탈수한다.");
		return 빨래감;
	}

}
