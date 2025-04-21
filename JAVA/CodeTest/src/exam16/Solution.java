package exam16;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public long solution(String numbers) {
        long answer = 0;
        
        /* 1. 배열 또는 List(0.38ms ~ 0.70ms)
        String[] arr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for (int i = 0; i < arr.length; i++) {
			numbers = numbers.replaceAll(arr[i], String.valueOf(i));
		}        
        answer = Long.parseLong(numbers);
        */
        
        // 2. map 사용(0.11ms ~ 0.18ms)
        Map<String, String> map = new HashMap<String, String>();
        map.put("zero", "0");
        map.put("one", "1");
        map.put("two", "2");
        map.put("three", "3");
        map.put("four", "4");
        map.put("five", "5");
        map.put("six", "6");
        map.put("seven", "7");
        map.put("eight", "8");
        map.put("nine", "9");
        
        for (String key : map.keySet()) {
			numbers = numbers.replace(key, map.get(key));
		}
        
        answer = Long.parseLong(numbers);
        
        
        
        return answer;
    }    
    
}





