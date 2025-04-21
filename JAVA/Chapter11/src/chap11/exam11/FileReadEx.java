package chap11.exam11;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileReadEx {

	public static void main(String[] args) throws IOException {
		// 파일 읽기
		// 1. 읽어올 파일 위치지정
		Path path = Paths.get("C:/img/temp/news.txt");
		
		// 2. 스트림 준비(주+보조)
		// 3. 읽기
		List<String> line = Files.readAllLines(path, Charset.forName("UTF-8"));
		for (String str : line) {
			System.out.println(str);
		}
		
		// 4. 자원반납

	}

}
