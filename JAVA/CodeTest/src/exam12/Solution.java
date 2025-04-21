package exam12;

public class Solution {
	
    public String solution(String my_string, String letter) {        
        String answer = "";                
        
        // 1. replace 로 치환 하기(0.02ms ~ 0.04ms)
        //answer = my_string.replace(letter, "");
        
        // 2. 문자열을 분리하여 재조립(0.09ms ~ 0.13ms)
        char[] arr = my_string.toCharArray();
        StringBuffer buffer = new StringBuffer();
        
        for (char c : arr) {
			if(c != letter.charAt(0)) {
				buffer.append(c);
			}
		}
        answer = buffer.toString();
        
        
        return answer;
    }

}
