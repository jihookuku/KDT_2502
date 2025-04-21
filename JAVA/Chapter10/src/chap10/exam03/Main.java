package chap10.exam03;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		
		// HashSet
		HashSet<String> set = new HashSet<String>();
		
		// 다형성 활용으로 Set 인터페이스 형태로 들어갈 수 있다.
		Set<Member> member = new HashSet<Member>();	
		
		// 데이터 추가
		set.add("JAVA");
		set.add("JSP");
		set.add("ORACLE");
		set.add("MVC");
		set.add("JAVA"); // 중복 데이터(아예 받지 않는 형태)
		
		member.add(new Member());
		member.add(new Member()); // 중복 데이터
		
		System.out.println("set  :"+set.size());
		System.out.println("member : "+member.size());
		
		// set 은 검색이 없기때문에 무언가를 찾을때 하나씩 뽑아내야 한다.
		
		Iterator<String> iter = set.iterator(); // 순서가 없는 set 에 하나씩 꺼내올수 있도록 임의의 순서를 정해준다.		
		//hasNext() 를 이용해 다음 값이 있다면 while 문을 진행
		while (iter.hasNext()) {
			 String val =  iter.next();
			 System.out.println(val);			
		}
		
		set.remove("ORACLE"); // ORACLE 삭제
		
		//향상된 for : Iterator 도 필요 없다.
		for (String val : set) {
			System.out.println("value : "+val);
		}
		
		set.clear();
		System.out.println("isEmpty : "+set.isEmpty());
		

	}

}

class Member{}















