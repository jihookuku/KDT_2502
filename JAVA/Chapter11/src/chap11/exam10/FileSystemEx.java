package chap11.exam10;

import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;

public class FileSystemEx {

	public static void main(String[] args) throws IOException {
		
		/*2. 파일 시스템 확인*/
		FileSystem fs = FileSystems.getDefault();
		
		// 저장소에 대한 기본 정보들
		Iterable<FileStore> infoList = fs.getFileStores();
		
		for (FileStore info : infoList) {
			System.out.println("드라이브 이름 : "+info.name());
			System.out.println("파일 시스템 타입 : "+info.type());
			System.out.println("전체공간 : "+(info.getTotalSpace()/1024/1024/1024)+" GB");
			System.out.println("사용 가능 공간 : "+(info.getUsableSpace()/1024/1024/1024)+" GB");
			System.out.println();
		}


	}

}
