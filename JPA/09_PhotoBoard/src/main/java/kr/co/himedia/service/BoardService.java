package kr.co.himedia.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.co.himedia.dto.BoardDTO;
import kr.co.himedia.entity.Board;
import kr.co.himedia.entity.Photo;
import kr.co.himedia.repo.BoardRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j // lombok 에서 log 를 쓸 수 있게 해 준다.
@RequiredArgsConstructor // lombok 에서 생성자 주입을 자동으로 해 준다.
public class BoardService {

	@Value("${spring.servlet.multipart.location}") 
	private String root;
		
	private final BoardRepo repo;

	public Map<String, Object> list(int no) {
		int pageForNum = 20;
		int offset = (no-1)*pageForNum;
		
		List<BoardDTO> list=repo.searchListByPage(offset,pageForNum);
		log.info("list : "+list);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("page", no);		
		return map;
	}

	public long write(MultipartFile[] files, Board dto) {
		
		if(files != null && files.length>0) {
			// 1. 파일을 물리적으로 저장
			for(MultipartFile file : files) {
				// 2. Photo 객체를 생성하여 반환
				Photo photo = saveFile(file);
				dto.addPhoto(photo); // 3. addPhoto 메서드를 통해 dto 객체에 추가
			}
		}	
		// 4. save 메서드를 통해 저장
		Board board = repo.save(dto);
		return board.getIdx();
	}

	private Photo saveFile(MultipartFile file) {
		// 1. 이름 추출
		String ori_filename = file.getOriginalFilename();
		// 2. 이름 변경
		String ext = ori_filename.substring(ori_filename.lastIndexOf("."));
		String new_filename = UUID.randomUUID()+ext;
	
		try {
			Path path = Paths.get(root+"/"+new_filename);// 3. 파일 저장
			Files.write(path, file.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}		
		// 4. DB 에 newFileName, oriFileName 저장
		Photo photo = new Photo(); 
		photo.setNewFileName(new_filename);
		photo.setOriFileName(ori_filename);
		return photo;		
	}

	public Board detail(long idx) {	
		return repo.findById(idx).get();		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
