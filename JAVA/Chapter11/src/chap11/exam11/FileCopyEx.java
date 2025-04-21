package chap11.exam11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileCopyEx {

	public static void main(String[] args) throws IOException {
		
		// 1. 가져올 곳과 내보낼곳 위치 지정
		Path src = Paths.get("C:/img/img.png");
		Path dst = Paths.get("C:/img/test/img.png");
		
		// 2. 스트림준비(주 in/out+보조 in/out)		
		
		// 3. 읽기 + 4. 읽은 내용 쓰기
		Files.copy(src, dst, StandardCopyOption.REPLACE_EXISTING);
		System.out.println("복사완료!!");
		
		// 5. 자원 반납(flush, close)

	}

}
