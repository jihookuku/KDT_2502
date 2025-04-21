package exam14;

public class Solution {
    public String solution(String my_string, int num1, int num2) {
        String answer = "";
        
        char[] arr = my_string.toCharArray();
        char pos1;
        char pos2;
        /*
        pos1 = arr[num1];
        pos2 = arr[num2];
        arr[num2] = pos1;
        arr[num1] = pos2;
        */
        
        pos1 = arr[num1];
        arr[num1] =  arr[num2];
        arr[num2] = pos1;
        
        
        answer = new String(arr);
        
        return answer;
    }
}
