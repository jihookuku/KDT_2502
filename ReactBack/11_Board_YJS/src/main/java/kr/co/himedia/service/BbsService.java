package kr.co.himedia.service;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	
	Logger logger = LoggerFactory.getLogger(getClass());

	public Map<String, Object> list(int page) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("page", page);
		int offset = (page - 1) * content_count;
		result.put("list", dao.list(offset, content_count));
		result.put("pages", dao.pages());
		
		return result;
	}

	public BbsDTO detail(int idx, boolean up) {
		
		if(up) {
			dao.upHit(idx);
		}
		
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

	public List<Map<String, String>> photoList(String idx) {
		
		List<Map<String, String>> list = new ArrayList<Map<String,String>>();
		
		try {
			list = dao.photoList(idx);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	public ResponseEntity<Resource> getFile(String file_idx, String type) {
		
		Resource res = null;
		HttpHeaders headers = new HttpHeaders();
		
		// 1. file_idx 를 이용해 new_filename, ori_filename 을 가져온다.
		Map<String, String> fileMap = dao.fileInfo(file_idx);
		logger.info("file map : "+fileMap);
		
		// 2. new_filename 으로 파일을 가져온다.
		res = new FileSystemResource(root+"/"+fileMap.get("new_filename"));
		
		// 3. photo 냐 download 냐 에 따라 Header 를 설정 해 준다.
		try {
			if(type.equals("photo")) {
				String content_type = Files.probeContentType(Paths.get(root+"/"+fileMap.get("new_filename")));
				headers.add("Content-Type", content_type);
			}else {
				headers.add("Content-Type", "application/octet-stream");		
				String ori_filename = URLEncoder.encode(fileMap.get("ori_filename"), "UTF-8");			
				headers.add("content-Disposition", "attachment;filename=\""+ori_filename+"\"");			
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}				
		//resource, header,status
		return new ResponseEntity<Resource>(res,headers,HttpStatus.OK);
	}

}




















