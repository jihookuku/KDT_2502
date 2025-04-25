package kr.co.himedia.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.co.himedia.dao.BbsDAO;
import kr.co.himedia.dto.BbsDTO;

@Service
public class BbsService {
	
	@Autowired BbsDAO dao;
	
	private int content_count = 5; // 한페이지당 몇개?
	
	@Value("${spring.servlet.multipart.location}")
	private String root;
	
	

	public Map<String, Object> list(int page) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("page", page);
		int offset = (page - 1) * content_count;
		result.put("list", dao.list(offset, content_count));
		result.put("pages", dao.pages());
		
		return result;
	}

	public BbsDTO detail(int idx) {
		return dao.detail(idx);
	}

	public boolean write(BbsDTO content, MultipartFile[] files) {
		int row = dao.write(content); // 글쓰기
		int idx = content.getIdx();		
		return fileSave(idx,files);		
	}
	
	private boolean fileSave(int idx, MultipartFile[] files) {
	
		boolean success = false;
		String ori_filename = "";
		String new_filename = "";
		String ext = "";
		
		for (MultipartFile file : files) {
			ori_filename = file.getOriginalFilename();// 1. 이름 추출
			ext = ori_filename.substring(ori_filename.lastIndexOf("."));
			new_filename = UUID.randomUUID()+ext; // 2. 이름 변경
			
			try {
				byte[] arr = file.getBytes(); // 3. 변경된 이름으로 파일 저장
				Path path = Paths.get(root+"/"+new_filename);
				Files.write(path, arr);
				// 4. db 에 해당 내용 저장(idx, ori_filename, new_filename)
				dao.fileWrite(idx,ori_filename, new_filename);				
				success = true;
			} catch (Exception e) {
				e.printStackTrace();
			}			
		}		
		
		return success;
	}

	public boolean update(BbsDTO content) {
		int row = dao.update(content);
		return row > 0 ? true : false;
	}

	public boolean delete(int idx) {
		int row = dao.delete(idx);
		return row > 0 ? true : false;
	}

}
