package exam13;

public class Solution {
    public String solution(String cipher, int code) {
        
    	String answer = "";       
        StringBuffer buffer = new StringBuffer();
        
        /* 1. 전체 문장을 돌면서 특정 배수의 값만 추출(0.09ms ~ 0.34ms)
        for (int i = 1; i <= cipher.length(); i++) {
        	if(i%code==0) {
        		//System.out.println(i+" : "+cipher.charAt(i-1));
        		buffer.append(cipher.charAt(i-1));
        	}			
		}
        answer = buffer.toString();
        */
        
        // 2. 특정 배수 만큼 건너뛰는 방식(0.08ms ~ 0.34ms)
        for (int i = 1; i <= cipher.length()/code; i++) {
			//System.out.println(i*code+":"+cipher.charAt(i*code-1));
        	buffer.append(cipher.charAt(i*code-1));
		}
        answer = buffer.toString();
        
        return answer;
    }
}
