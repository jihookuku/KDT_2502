package chap04.exam03;

public class Main {

	public static void main(String[] args) {

		// 1. Student 형태를 담는 변수 반들고
		// 2. new(새로) 복사해서 넣는다.
		Student std1 = new Student();
		Student std2 = new Student();
		// std1 과 std2 는 서로 다른 복사본 이기 때문에 == 로 비교하면 다르다고 나온다.
		// String 역시도 클래스이며 사용할때 복사하여 사용하므로 == 로 비교하면 안된다.
		System.out.println(std1 == std2);
		System.out.println(std1);
		System.out.println(std2);
		
		String str = "안녕하세요!"; // String 이라는 객체가 생성된 것
		String str2 = new String("안녕하세요!"); // 원래는 이렇게 선언하는 것
		
		int len = str.length();
		System.out.println("str 의 길이 : "+len);
		
		String name = std1.getName("김지훈");
		System.out.println(name);
		
	}

}











