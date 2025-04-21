package chap11.exam03;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;

public class Main {

	public static void main(String[] args) throws IOException {
		// 1. 읽어올 파일 위치 지정
		String path  ="C:/img/temp/news.txt";
		
		// 2. 파일 객체 준비
		File file = new File(path);		
		
		// 3. 스트림(빨대 준비)
		FileReader reader = new FileReader(file, Charset.forName("UTF-8"));
		
		// 4. 하나씩 읽어온다.
		int data;
		/*
		while((data = reader.read()) != -1) {
			System.out.print((char)data);
		}
		*/
		while(true) {
			data = reader.read();
			if(data == -1) { // -1 은 EOF(End Of File) 을 뜻한다. 더이상 읽을게 없다는 뜻
				break;
			}
			System.out.print((char)data);
		}
		
		
		// 5. 회수한다.
		reader.close();

	}

}









