package kr.co.himedia.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import kr.co.himedia.dao.BoardDAO;
import kr.co.himedia.dto.BoardDTO;
import kr.co.himedia.dto.PhotoDTO;

@Service
public class BoardService {

	Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	BoardDAO dao;
	
	private String root = "C:/upload/";

	public void write(String subject, String user_name, String content, MultipartFile[] files) {		
		// 방금 insert 한 key 값을 가져오는 방법
		// 조건 1. 파라메터를 DTO 형태로 전달 해야 한다.
		BoardDTO dto = new BoardDTO();
		dto.setSubject(subject);
		dto.setContent(content);
		dto.setUser_name(user_name);			
		dao.write(dto); // 1. 게시글 저장	
		int idx = dto.getIdx();
		log.info("방금 넣은 idx 번호 : "+idx);
		
		//파일명이 있으면 == 파일이 있으면, 그때 파일 저장 로직을 실행
		if(!files[0].getOriginalFilename().equals("")) {
			fileSave(files,idx);// 2. files 저장
		}
				
	}
	
	public void fileSave(MultipartFile[] files, int idx) {		
		for (MultipartFile file : files) {			
			String ori_filename = file.getOriginalFilename();// 1. 이름 추출			
			String ext = ori_filename.substring(ori_filename.lastIndexOf("."));
			String new_filename = UUID.randomUUID().toString()+ext;	// 2. 이름 변경					
			try {
				byte[] arr = file.getBytes();
				Path path = Paths.get(root+new_filename);
				Files.write(path, arr); // 3. 파일 저장
				dao.fileSave(ori_filename, new_filename, idx);// 4. DB 에 저장
				
			} catch (IOException e) {
				e.printStackTrace();
			}						
			
		}
		
	}
	
	public ArrayList<BoardDTO> list() {
		return dao.list();
	}
	
	
	//rollbackFor : 지정한 예외 발생시에만 롤백을 수행
	//noRollbackFor : 지정한 예외 발생시에는 롤백을 수행하지 않는다.
	// isolation = 데이터 CRUD 허용 수준	
	// Isolation.READ_COMMITTED		: 누군가(트랜잭션) 커밋한 내용만 다른 누군가(트랜잭션)가 볼 수 있다.
	// Isolation.READ_UNCOMMITTED	: 아직 커밋되지 않은 내용을 다른 누군가도 볼 수 있다.
	// Isolation.REPEATABLE_READ		: 누군가가 보고 있으면 다른 누군가는 UPDATE 할 수 없다.
	// Isolation.SERIALIZABLE				: 누군가가 커밋할 떄 까지 다른 누군가는 아무것도(CRUD) 할 수 없다.
	@Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED) // default
	public BoardDTO detail(String idx) {		
		// bHit 성공 후 detail 에서 문제 생겼을 경우 bHit 의 실행도 취소시키고 싶을때
		dao.bHit(idx);		
		return dao.detail(idx);
	}

	public void del(String idx) {
		dao.del(idx);
	}

	public BoardDTO updateForm(String idx) {
		
		return dao.detail(idx);
	}

	public void update(Map<String, String> param) {
		dao.update(param);
	}

	public List<PhotoDTO> photos(String idx) {		
		return dao.photos(idx);
	}

	
}




















