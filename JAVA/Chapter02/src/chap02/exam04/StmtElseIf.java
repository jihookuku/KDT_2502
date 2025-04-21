package chap02.exam04;

import java.util.Scanner;

public class StmtElseIf {

	public static void main(String[] args) {
		
		// 자판기에 음료를 선택하면 음료가 출력되도록 할 예정
		// 우리가 가지고 있는 음료 : 콜라, 생수, 오렌지주스, 에너지음료,이온음료, 커피, 식혜
		System.out.println("원하는 음료를 선택 하세요 : ");
		Scanner scan = new Scanner(System.in);
		String item = scan.nextLine();
		System.out.println(item);
		
		if (item.equals("콜라")) {
			System.out.println("콜라가 나왔습니다.");
		}else if (item.equals("생수")) {
			System.out.println("생수가 나왔습니다.");
		}else if (item.equals("오렌지주스")) {
			System.out.println("오렌지주스가 나왔습니다.");
		}else if (item.equals("에너지음료")) {
			System.out.println("에너지음료가 나왔습니다.");
		}else if (item.equals("이온음료")) {
			System.out.println("이온음료가 나왔습니다.");
		}else if (item.equals("커피")) {
			System.out.println("커피가 나왔습니다.");
		}else if (item.equals("식혜")) {
			System.out.println("식혜가 나왔습니다.");
		}else {
			System.out.println("목록에 없는 음료 입니다.");
		}
		/*
		if (!item.equals("콜라") && !item.equals("생수") && !item.equals("오렌지주스") && !item.equals("에너지음료")
				&& !item.equals("커피") && !item.equals("식혜")) {
			System.out.println("목록에 없는 음료 입니다.");
		}
		*/
		
		


	}

}
