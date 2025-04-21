package chap11.exam05;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) throws IOException {
		// Scanner 로 입력 받은 내용을 파일에 저장하기
		// 저장될 파일 위치 : C:/img/temp/sample.txt
		
		// 1. 파일 위치 지정 + 파일 객체화 + 스트림 준비
		FileWriter writer = new FileWriter("C:/img/temp/sample.txt", true);
		
		// 2. Scanner준비 및 입력
		System.out.print("입력 내용 : ");
		Scanner scan = new Scanner(System.in);
		String msg = scan.nextLine();
		
		// 3. 쓰기
		writer.write(msg+"\r\n");
		
		// 4. 자원정리
		writer.flush();
		writer.close();
		scan.close();
		
	}

}






