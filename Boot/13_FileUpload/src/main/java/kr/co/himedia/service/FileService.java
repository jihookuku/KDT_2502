package kr.co.himedia.service;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	private String root = "C:/upload/";
	
	public void upload(MultipartFile file) {
		// 1. 파일 이름 추출(chrome.png)
		String ori_filename = file.getOriginalFilename();
		
		//1-2. 확장자 추출
		//String[] names = ori_filename.split("\\.");
		//logger.info(Arrays.toString(names));
		int dot = ori_filename.lastIndexOf(".");		
		String ext = ori_filename.substring(dot);		
		logger.info("확장자 : "+ext);
		
		// 2. 파일이름 변경(1234.png)
		String new_filename = UUID.randomUUID().toString()+ext;
		
		 // 3. 파일 저장
		try {
			byte[] arr = file.getBytes();		
			Path path = Paths.get(root+new_filename);
			Files.write(path, arr);			
		} catch (IOException e) {
			e.printStackTrace();
		}		
		
	}

	public void multiUpload(MultipartFile[] files) {		
		for (MultipartFile file : files) {
			upload(file);
		}		
	}

	public String[] photoList() {		
		return new File(root).list();
	}

	public void delFile(String name) {
		File file = new File(root+name);
		if(file.exists()) {
			file.delete();
		}		
	}

	public ResponseEntity<Resource> download(String file) {

		// 1. 특정 경로에 있는 파일을 불러 Resource 형태로 만들어 준다.
		Resource res = new FileSystemResource(root+file);
		
		// 2. 헤더값에 보낼 정보를 명시해 준다.
		HttpHeaders header = new HttpHeaders();
	
		try {
			// content-type : image, text, html, json,...
			header.add("content-type", "application/octet-stream");
			//content-Disposition : 추출하려는 컨텐트 형태(inline:문자열,attachment:첨부파일)
			// 다만 한글 파일은 한글깨짐이 있을수 있어 아래의 처리가 추가로 필요하다. 
			String downFile = URLEncoder.encode(file, "UTF-8");
			//filename=""
			header.add("content-Disposition", "attatchment;filename=\""+downFile+"\"");
		} catch (Exception e) {
			e.printStackTrace();
		}		

		//바디(보낼내용),헤더, 상태
		return new ResponseEntity<Resource>(res, header, 200);
	}
	
	

}


















