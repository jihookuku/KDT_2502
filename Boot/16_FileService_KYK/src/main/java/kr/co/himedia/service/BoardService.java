package kr.co.himedia.service;

import java.io.File;
import java.io.IOException;
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
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import kr.co.himedia.dao.BoardDAO;
import kr.co.himedia.dto.BoardDTO;
import kr.co.himedia.dto.PhotoDTO;

@Service
public class BoardService {

	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	BoardDAO dao;
	
	private String root = "C:/upload/";

	public ArrayList<BoardDTO> list() {
		return dao.list();
	}

	public int write(String subject, String user_name, String content, MultipartFile[] files) {
		BoardDTO dto = new BoardDTO();
		dto.setSubject(subject);
		dto.setUser_name(user_name);
		dto.setContent(content);
		
		int row = dao.write(dto);
		logger.info("write row" +row);
		
		int idx= dto.getIdx();
		logger.info("방금 입력한 게시글 번호"+idx);
		
		if (!files[0].getOriginalFilename().equals("")) {
			fileSave(idx,files);
		}
				
		return idx;
	}
	
	

	private void fileSave(int idx, MultipartFile[] files) {
		String ori_filename = "";
		String new_filename = "";
		for (MultipartFile file : files) {
			ori_filename = file.getOriginalFilename();
			logger.info(ori_filename);
			if (!ori_filename.equals("")) {
				String ext = ori_filename.substring(ori_filename.lastIndexOf("."));
				new_filename = UUID.randomUUID().toString() + ext;
				try {
					logger.info(ori_filename + "저장");
					Path path = Paths.get("C:/upload/" + new_filename);
					byte[] arr = file.getBytes();
					Files.write(path, arr);
					dao.fileSave(ori_filename, new_filename, idx);
				} catch (IOException e) {
					e.printStackTrace();
				}

			}

		}

	}

	public BoardDTO detail(String idx) {
		dao.upHit(idx); 
		return dao.detail(idx);

	}

	@Transactional
	public int del(String idx) {
		// 0. 파일명 추출
		List<String> fileList = dao.getFiles(idx);
		// 1. 자식 지우기
		dao.delPhoto(idx);
		// 2. 글 지우기
		int row = dao.del(idx);		
		// 3. 파일 지우기
		for (String name : fileList) {
			File file = new File("C:/upload/"+name);
			if(file.exists()) {
				file.delete();
			}
		}
		
		return row;
	}

	public BoardDTO updateForm(String idx) {
		return dao.detail(idx);
	}

	public void update(Map<String, String> param, 
			MultipartFile[] files) {
		
		int row = dao.update(param);
		logger.info("updated row : "+row);
		
		if (!files[0].getOriginalFilename().equals("")) {
			int idx = Integer.parseInt(param.get("idx"));
			fileSave(idx,files);
		}
				
	}

	public List<PhotoDTO> photos(String idx) {
		return dao.photos(idx);
	}

	
}













