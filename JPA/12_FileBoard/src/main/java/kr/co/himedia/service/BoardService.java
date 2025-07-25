package kr.co.himedia.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.transaction.Transactional;

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
@Slf4j
@RequiredArgsConstructor
public class BoardService {
	
	@Value("${spring.servlet.multipart.location}") 
	private String root;
	
	private final BoardRepo repo;

	public Map<String, Object> list(int no) {
		int pageForNum = 20;
		int offset = (no-1)*pageForNum;
		
		List<BoardDTO> list=repo.searchListByPage(offset,pageForNum);
		log.info("list : "+list);
		
		for (BoardDTO dto : list) {
	        log.info("BoardDTO - idx: {}, subject: {}, bHit: {}", dto.getIdx(), dto.getSubject(), dto.getBHit());
	    }
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("page", no);
		log.info("Response map: {}", map);
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

	@Transactional
	public Board detail(long idx) {
	    Board board = repo.findById(idx).orElseThrow(); // 게시글 조회
	    board.setBHit(board.getBHit() + 1); // 조회수 +1
	    return board; // 저장은 트랜잭션 종료 시 자동 반영됨 (JPA의 dirty checking)
	}

	public void delete(long idx) {
		//1. photo 를 통해 사진이 있는지 확인		
		List<Photo> list = repo.findById(idx).get().getPhotos();	
			
		//2.  데이터 삭제(Cascade 에 의해 자식도 지워짐)
		repo.deleteById(idx);
				
		//3. 사진이 있다면 삭제
		for (Photo p : list) {
			File file = new File(root+"/"+p.getNewFileName());
			boolean success = file.delete();
			log.info(p.getNewFileName()+" delete : "+success);
		}	
		
	}
	
	
}
