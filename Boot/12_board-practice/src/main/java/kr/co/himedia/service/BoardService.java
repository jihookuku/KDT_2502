package kr.co.himedia.service;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import kr.co.himedia.dao.BoardDAO;
import kr.co.himedia.dto.BoardDTO;
import kr.co.himedia.dto.PhotoDTO;

@Service
public class BoardService {

	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired BoardDAO dao;

	public ArrayList<BoardDTO> list() {

		return dao.list();
	}

	public int write(String subject, String user_name, 
			String content, MultipartFile[] files) {
		
		// 1. 글쓰기 -> 방금 입력한  글 번호를 가져온다.
		BoardDTO dto = new BoardDTO();
		dto.setSubject(subject);
		dto.setUser_name(user_name);
		dto.setContent(content);	
		
		int row = dao.write(dto);
		logger.info("write row : " + row);
		// 2. 파일 저장 - 입력한 글번호, 파일 객체들...	
		int idx = dto.getIdx();
		logger.info("방금 입력한 게시글 번호 : "+idx);
		fileSave(idx,files);
		return idx;
	}
	
	public int update(Map<String, String> param
			,MultipartFile[] files) {
		
		// 1. 글 수정
		int row = dao.update(param);		
		// 2. 파일 저장
		int idx = Integer.parseInt(param.get("idx"));
		fileSave(idx, files);
		
		return row;
	}
	
	private void fileSave(int idx, MultipartFile[] files) {
		
		// 1. files 에서 하나씩 꺼내기
		String ori_filename = "";
		String new_filename = "";
		
		for (MultipartFile file : files) {
			ori_filename = file.getOriginalFilename();
			// 2. 이름검사 -> 이름이 없으면 실행하지 않는다.
			if(!ori_filename.equals("")) {
				// 3. 파일 저장
				// 1) 파일명 변경
				String ext = ori_filename.substring(ori_filename.lastIndexOf("."));
				new_filename = UUID.randomUUID().toString()+ext;
				try {
					// 2) 저장
					Path path = Paths.get("C:/upload/"+new_filename);
					byte[] arr = file.getBytes();
					Files.write(path, arr);
					// 4. DB 에 입력
					dao.fileSave(ori_filename,new_filename,idx);
					
				} catch (IOException e) {
					e.printStackTrace();
				}				
			}
		}		
	}

	public BoardDTO detail(String idx) {
		dao.uphit(idx);
		return dao.detail(idx);
	}

	@Transactional
	public int del(String idx) {
		// 0. photo 에서 해당 idx 의 new_filename 들을 가져 온다.
		List<String> fileList = dao.getFileName(idx);
		// 1. photo 에서 해당 idx 글을 지운다.
		dao.delFiles(idx);
		// 2. bbs 에서 해당 idx 글을 지운다.
		int row = dao.del(idx);		
		// 3. new_filename 을 이용해 파일을 삭제 한다.
		logger.info("fileList : {}",fileList);
		for (String fileName : fileList) {
			File file = new File("C:/upload/"+fileName);
			if(file.exists()) {
				file.delete();
			}
		}
		
		return row;
	}

	public BoardDTO updateForm(String idx) {
		return dao.detail(idx);
	}

	public List<PhotoDTO> photos(String idx) {
		return dao.photos(idx);
	}

	public ResponseEntity<Resource> download(String idx) {
		
		// 1.fileIdx 를 이용하여 new_filename, ori_filename 을 가져오기
		PhotoDTO photo = dao.download(idx);
		// 2. new_filename 을 이용해 파일 가져오기
		Resource res = new FileSystemResource("C:/upload/"+photo.getNew_filename());
		HttpHeaders header = new HttpHeaders();
		
		// 3. 다운로드로 보낼때 이름 변경해 주기
		try {
			String fileName = URLEncoder.encode(photo.getOri_filename(), "UTF-8");
			header.add("content-type", "application/octet-stream");
			header.add("content-Disposition", "attachment;filename=\""+fileName+"\"");			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Resource>(res, header, 200);
	}
		
}


















