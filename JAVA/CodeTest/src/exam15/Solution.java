package exam15;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	
    public String solution(String letter) {//0.15ms ~ 0.26ms
        String answer = "";        
        Map<String, String> morse = makeMap(); // morse 부호와 알파벳이 있는  맵을 생성후 반환

        StringBuffer buffer = new StringBuffer();
        for (String key : letter.split(" ")) { // 받아온 값을 공백을 기준으로 잘라서 배열에 저장 -> 향상된 for 를 통해 한글자씩 내보낸다.
			buffer.append(morse.get(key)); // 효율성을 위해 StringBuffer 를 활용하여 morse 로 부터 받아온 값을 이어 붙인다.
		}
        answer = buffer.toString();// StringBuffer 를 String 으로 만든다.
        
        return answer;
    }
    
    public Map<String, String> makeMap() {
    	
    	String[] keys = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
    	String[] values = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
    	Map<String, String> map = new HashMap<String, String>();
    	
    	for (int i = 0; i < values.length; i++) {
    		map.put(keys[i], values[i]);			
		}
    	return map;
    }

}
