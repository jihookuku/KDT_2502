package chap10.exam01;

import java.util.ArrayList;
import java.util.List;

public class ArrayList01 {

	public static void main(String[] args) {
		
		// ArrayList 선언, 추가, 삭제, 출력
		// 어레이리스트는 크기를 지정해도 되고 안해도 된다.(일반적으로 안함)
		ArrayList<String> list = new ArrayList<String>(3);
		// 다형성 활용도 가능
		//List<String> list2 = new ArrayList<String>(3);
		list.add("collection"); 	//0
		list.add("thread"); 		//1
		list.add("java io");		//2
		list.add("network");		//3 <- 배열같았으면 예외 발생
		list.add(3, "lambda");	// 3번인덱스에 들어가고, 3번 인덱스의 내용은 4번으로 밀리게 된다.
		System.out.println(list); // 배열과 다르게 내부를 보여준다.
		
		//list.size();// 리스트의 크기를 알려 준다.
		//list.get(0); // 0번 인덱스의 값을 반환 한다.
		for (int i = 0; i < list.size(); i++) {
			System.out.println(i+" : "+list.get(i));
		}
		
		// 데이터 삭제
		System.out.println("니가 지운 값 : "+list.remove(2));
		System.out.println("삭제 성공 여부  :"+list.remove("network"));
		
		for (String item : list) {
			System.out.println(item);
		}
		
		
		
		
		
		
		
		
		


	}

}
