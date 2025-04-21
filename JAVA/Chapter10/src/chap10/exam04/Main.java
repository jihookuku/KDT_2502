package chap10.exam04;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		
		//HashMap
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		// add() 가 아닌 put() 이라는 메서드로 값을 넣는다.
		map.put("kim", 23);
		map.put("lee", 26);	
		map.put("park", 26);// 값 중복(허용)
		map.put("kim", 40);	// 키 중복(허용X - 덮어쓴다.)
		
		System.out.println(map.size()); // 키에대한 중복은 허용하지 않기때문에 3개만 나온다.
		System.out.println(map.get("kim")); // 키가 kim 인 값을 가져온다.
		System.out.println(map.remove("lee"));// 키를 넣어 지우면 지워진 값을 반환 해 준다.
		
		// 모든값 꺼내오기
		// 1. 키만 set 으로 가져온다. -> set 을 하나씩 꺼낼수 있도록 만든다. -> 키를 하나씩 꺼낸다. -> 키에 해당하는 값을 가져온다.
		System.out.println("모든값 꺼내오는 방법 1");
		Set<String> keySet = map.keySet(); // 1
		Iterator<String> iter = keySet.iterator();//2
				
		while (iter.hasNext()) {
			String key = iter.next();//3
			System.out.println(key+" : "+map.get(key));//4			
		}
		
		
		// 2. key-value 형태(Entry)로 Set 을 만든다. -> 하나씩 꺼낼수 있도록 만든다. -> Entry 로 부터 키와 값을 꺼낸다.
		System.out.println("모든값 꺼내오는 방법 2");
		Set<Entry<String, Integer>> entrySet = map.entrySet();//1		
		Iterator<Entry<String, Integer>> entry = entrySet.iterator();//2
		
		while (entry.hasNext()) {
			Entry<String, Integer> kv = entry.next();
			System.out.println(kv.getKey()+" : "+kv.getValue());//3
		}
		
		// 3. keySet 과 향상된 for 활용한 방법
		System.out.println("모든값 꺼내오는 방법 3");
		for (String key : map.keySet()) {
			System.out.println(key+" : "+map.get(key));
		}
		
		// 4. 만약에 map 이 비어있지 않으면 비우기
		if (!map.isEmpty()) {
			map.clear();
		}		
		
		
		
		
		


	}

}
