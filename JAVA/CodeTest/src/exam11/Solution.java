package exam11;

public class Solution {
    public String solution(String my_string, int n) {
        
    	String answer = "";
    	
    	// 1. my_string 을 한글자씩 끊어낸다.(0.11ms ~ 0.16ms)
    	String[] arr = my_string.split("");
    	
    	StringBuilder builder = new StringBuilder();// 메모리 효율성을 위해 이녀석 사용
    	
    	for (String str : arr) {// 한글자씩 꺼내서...    		
    		for (int i = 0; i < n; i++) {
				builder.append(str); // 추가해 준다.
			}
		}
    	answer = builder.toString();        
    	
        return answer;
    }
}
