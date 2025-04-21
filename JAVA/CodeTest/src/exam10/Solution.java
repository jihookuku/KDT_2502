package exam10;

public class Solution {
	
    public String solution(String my_string) {
        String answer = "";
        
        // 1. 순수 배열(0.01ms ~ 0.02ms)
        // 1-1. 배열 준비
        int len = my_string.length();
        char[] arr = new char[len];
        
        //1-2. my_string 의 글자를 하나씩 뽑아내서 arr 에 역순으로 넣는다.
        for (int i = 0; i < arr.length; i++) {
        	arr[len-1-i] = my_string.charAt(i);
		}
        
        answer = new String(arr);
        
        
        // 문자열 == 문자 array
        
        /* 2. reverse(0.02ms ~ 0.06ms)
        StringBuffer buffer = new StringBuffer(my_string);
        answer = buffer.reverse().toString();
        */     
        return answer;
    }

}
