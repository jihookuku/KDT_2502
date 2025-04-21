package chap01.exam02;

public class VarScope {
	
	String str = "아무거나 입력해도 되요";

	public static void main(String[] args) {
		
		int number = 123;
		
		for (int i = 0; i < 5; i++) {
			int sum = number + i;
			System.out.println(sum);
		}
		
		//System.out.println(sum);//sum 은 밖을 나올수 없다.
		
	}

}
