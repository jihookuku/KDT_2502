package exam06;

public class Solution {
	
    public int solution(int n, int k) {
    	int answer = -1;   
    	
    	int yang = n * 12000;
    	int drink = k * 2000;
    	int free = (n/10) * 2000;
    	answer = yang+drink-free;
    	
        return answer;
    }

}
