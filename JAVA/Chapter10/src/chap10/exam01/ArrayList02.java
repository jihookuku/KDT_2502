package chap10.exam01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayList02 {

	public static void main(String[] args) {
		// Vector 는 ArrayList 와 사용법이 똑같다.
		// 다만 동시접근 유저(스레드) 를 허용하지 않을 뿐이다.
		
		// 배열 -> List -> ArrayList
		String[] arr = {"List","Set","Map"};
		
		// 1. Array -> List 변경
		List<String> list = Arrays.asList(arr);
		System.out.println(list);
		System.out.println(list.size());
		System.out.println(list.get(1));
		//list.add("Collection"); //List 인터페이스 형태로는 데이터 변형이 안된다.
		
		// 2. 데이터 추가를 원한다면 진짜 ArrayList 로 만들어야 한다.
		ArrayList<String> arrList = new ArrayList<String>();
		arrList.addAll(list);
		arrList.add("collection");//이제 데이터 추가도 가능하다!
		System.out.println(arrList);

	}

}






