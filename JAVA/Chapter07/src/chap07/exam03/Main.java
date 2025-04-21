package chap07.exam03;

public class Main {

	public static void main(String[] args) {
		
		String str = "문자열을"; 			//1
		str += " 추가하면";					//2
		str += " 각 객체가 생성 된다.";	//3
		System.out.println("String : "+str);
		
		StringBuffer buffer = new StringBuffer("문자열을");
		buffer.append(" 추가하면");
		buffer.append(" 한 객체의 크기만 커진다.");
		System.out.println("buffer : "+buffer.toString());
		
		StringBuilder builder = new StringBuilder("builder 와 buffer 의 차이점은");
		builder.append("builder 는 유저의 동시 접근을 허용하고,");
		builder.append("buffer 는 허용하지 않는다.");
		System.out.println("builder : "+builder.toString());
		
		builder.reverse(); // 원본을 건드린다.(뒤집기 기능)
		System.out.println("builder : "+builder.toString());

	}

}
