package chap11.exam11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileWriteEx {

	public static void main(String[] args) throws IOException {
		
		// 파일 쓰기		
		// 1. 위치 지정
		Path path = Paths.get("C:/img/test/test.txt");
		
		// 2. 스트림준비(주+보조) - java.nio 에선 필요 없음
		
		// 3. 쓰기
		Files.writeString(path, "아무거나 입력!!\r\n", StandardOpenOption.APPEND, StandardOpenOption.CREATE);
		/* APPEND : 이어서 쓰기 모드
		 * WRITE : 쓰기모드(기본)
		 * CREATE : 파일이 존재하지 않으면 새로 만든다.
		 * CREATE_NEW : 이미 파일이 존재해도 새로 만든다.
		 * READ : 읽기모드
		 */
		System.out.println("저장이 완료 되었습니다.");
		
		// 4. 자원 반납(flush+close) - java.nio 에선 필요 없음

	}

}
