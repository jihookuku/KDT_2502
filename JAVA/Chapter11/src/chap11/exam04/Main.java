package chap11.exam04;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		
		// 1. 파일 위치 지정
		String path = "C:/img/temp/test.txt";
		
		// 2. 객체화
		File file = new File(path);
		
		// 3. 스트림 준비
		FileWriter writer = new FileWriter(file, true); // 두번째 인자값은 이어 쓰기 여부(false 면 사용할 때 마다 파일을 덮어쓴다.)
		
		// 4. 쓰기
		writer.write("Hello, JAVA I.O.\r\n");//new line - 줄바꿈을 의미
		
		// 5. flush + close
		writer.flush(); // 내보낼때 이게 없으면 안된다.
		writer.close();
		System.out.println("저장 종료!");

	}

}








