package chap02.exam05;

import java.util.Scanner;

public class Japangi {

	public static void main(String[] args) {
		
		System.out.println("원하는 음료를 선택 하세요!");
		Scanner scan = new Scanner(System.in);
		String item = scan.nextLine();
		System.out.println("선택한 음료 : "+item);
		
		// 우리가 가지고 있는 음료 : 콜라, 생수, 오렌지주스, 에너지음료,이온음료, 커피, 식혜
		// 1.6 버전에서는 switch 문의 case 는 숫자나 char만 가능 하다.
		// 모든 문장은 { 로 시작했으면 } 으로 끝날때까지 실행 된다.
		// 그래서 생수를 선택했을때 오렌즈주스, default  까지 실행된 것이다.
		// {} 을 중간에 탈출하기 위해서 break 문을 사용 한 것이다.
		switch (item) { // switch 문은 조건이 아닌 값이 들어간다.
		case "콜라":
			System.out.println("콜라가 나왔습니다.");
			break;
			
		case "생수":
			System.out.println("생수가 나왔습니다.");
			break;
			
		case "오렌지주스":
			System.out.println("오렌지주스가 나왔습니다.");
			break;

		default://else 와 같다.
			System.out.println("목록에 없는 음료 입니다.");
			//break;
		}
		


	}

}
