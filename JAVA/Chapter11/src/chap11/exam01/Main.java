package chap11.exam01;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("문자열 입력> ");
		String msg = scan.nextLine();
		System.out.println(msg);
		
		System.out.print("정수 입력> ");
		int val = scan.nextInt();
		System.out.println(val);
	}

}
