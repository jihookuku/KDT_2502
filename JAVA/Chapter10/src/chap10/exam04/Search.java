package chap10.exam04;

import java.util.Hashtable;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Search {

	public static void main(String[] args) {
		
		Map<String, Integer> map = new Hashtable<String, Integer>();
		
		map.put("김철호", 99);//이름, 점수
		map.put("박동빈", 80);
		map.put("박은비", 75);
		map.put("신솔비", 43);
		map.put("한은정", 52);
		map.put("김민지", 100);
		map.put("김윤경", 80);
		map.put("정철수", 99);
		map.put("안은호", 87);
		map.put("최영일", 75);
		
		//containsKey : 해당 키가 존재 하는지 여부
		boolean bool = map.containsKey("박은비");
		System.out.println(bool);
		System.out.println("박은비의 점수는 ? "+map.get("박은비"));
		
		//containsValue : 해당 값이 존재하는지 여부
		System.out.println("99점이 존재하는가? "+map.containsValue(99));
		
		// 99점 맞은 사람은 누구?
		// 1. 엔트리를 이용해서 점수 확인 -> 이름 알아보기
		Set<Entry<String, Integer>> entrySet = map.entrySet();
		for (Entry<String, Integer> entry : entrySet) {
			if(entry.getValue() !=99) {
				continue;
			}			
			System.out.println(entry.getKey()+" : "+entry.getValue());
		}
			
		// 2. 키를 이용해서 해당 점수의 키 알아보기
		int val = 0;
		for (String key : map.keySet()) {
			val = map.get(key);
			if(val == 99) {
				System.out.println(key+" : "+val);
			}
		}
		
		

	}

}








