package chap02.exam09;

import java.util.Scanner;

public class GuguDan {

	public static void main(String[] args) {
		System.out.println("원하는 단을 입력 하세요!");
		// 원하는 단 입력 하면 해당 단 출력
		// 예: 2를 입력 하면 2 X 1 =2 ~ 2 X 9 = 18 까지 출력 되도록 
		Scanner scan = new Scanner(System.in);
		int dan = scan.nextInt();// 숫자 입력 받음
		System.out.println(dan+" 단 출력");
		
		for (int i = 1; i <= 9; i++) {
			System.out.println(dan+" X "+i+" = "+(dan*i));
		}
		
	}

}
