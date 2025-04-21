package chap11.exam10;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathExam {

	public static void main(String[] args) {
		
		/*1. 경로특화 클래스 Path*/
		Path path = Paths.get("C:/img/temp/copy.png");
		System.out.println("특정 경로의 파일 이름 : "+path.getFileName());
		System.out.println("부모 폴더 이름 : "+path.getParent().getFileName());
		System.out.println("루트 : "+path.getRoot());
		
		System.out.println("name count ? "+path.getNameCount());//3? ->  이 경로 까지의 단계
		
		for (int i = 0; i < path.getNameCount(); i++) {
			System.out.print("/"+path.getName(i));
		}
		


	}

}
