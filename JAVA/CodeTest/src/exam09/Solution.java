package exam09;

public class Solution {
	
	// 7조각을 10명이 나누어 먹는다?
	// 못먹는 사람은 없어야 한다.
    public int solution(int slice, int n) {
        int answer = 1;
        
        // 피자를 시켜서 나누어줬을때 1인 1조각 이상이 돌아가는지 확인
        while(answer*slice / n == 0) {
        	answer++; // 1조각도 못받은 사람이 있으면 주문량을 늘린다.
        }
        
        // n 명이 slice 조각 짜리 피자를 얼마나 시켜야 하나?
        //answer = n % slice > 0 ? n/slice+1 : n/slice;
        
        
        return answer;
    }

}
