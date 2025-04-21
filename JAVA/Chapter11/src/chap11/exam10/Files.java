package chap11.exam10;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Files {

	public static void main(String[] args) throws IOException {
		/*3.파일 정보, 파일 다루기도 포함 한다.*/
		Path path = Paths.get("C:/img/img.gif");
		
		// 같은 이름의 클래스를 사용한 결과(어디서 온 Files 인지 표기해 줘야 한다.)
		System.out.println("디렉토리 여부 : "+java.nio.file.Files.isDirectory(path));
		System.out.println("파일 여부 : "+java.nio.file.Files.isRegularFile(path));
		System.out.println("마지막 파일  수정시간 : "+java.nio.file.Files.getLastModifiedTime(path));
		System.out.println("파일 크기 : "+java.nio.file.Files.size(path));
		System.out.println("소유자 : "+java.nio.file.Files.getOwner(path));
		System.out.println("숨김 여부 : "+java.nio.file.Files.isHidden(path));
		System.out.println("읽기가능 여부 : "+java.nio.file.Files.isReadable(path));
		System.out.println("쓰기가능 여부 : "+java.nio.file.Files.isWritable(path));
		
		/*4. 파일 생성 디렉토리 생성*/
		Path dir = Paths.get("C:/img/test");
		
		boolean exists = java.nio.file.Files.notExists(dir);
		System.out.println("존재하지 않는가?"+exists);
		if(exists) {
			System.out.println("디렉토리 생성");
			java.nio.file.Files.createDirectory(dir);
		}
		
		Path file = Paths.get("C:/img/test/test.txt");
		
		if (java.nio.file.Files.notExists(file)) {
			System.out.println("파일 생성");
			java.nio.file.Files.createFile(file);
		}
		
		
		
		
		
		
		
		
		

	}

}
