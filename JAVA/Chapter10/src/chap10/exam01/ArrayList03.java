package chap10.exam01;

import java.util.LinkedList;
import java.util.List;

public class ArrayList03 {

	public static void main(String[] args) {
		
		// ArrayList 와 구조는 다르지만 사용 방법은 거의 동일하다.
		List<Integer> list = new LinkedList<Integer>();
		
		list.add(70);	//0
		list.add(80);	//1
		list.add(50);	//2
		list.add(90);	//3
		list.add(100);	//4
		list.add(90);	//5
		
		//set(index,value) :  이전값 - 특정 인덱스 값을 수정
		int val = list.set(3, 95);
		System.out.println(val);
		
		// contains("값") : 포함여부 - 특정값 포함 여부 확인
		boolean result = list.contains(30);
		System.out.println(result);
		
		// indexOf("값") : 해당 인덱스 - 특정값의 인덱스 확인
		val = list.indexOf(90);
		System.out.println(val);
		
		//clear() - 리스트 내 모든 내용을 삭제
		list.clear();
		
		//isEmpty() : 비어있는지 여부
		result = list.isEmpty();
		System.out.println(result);
		System.out.println(list);
		
	}

}







