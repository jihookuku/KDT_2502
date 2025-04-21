package kr.co.himedia.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.himedia.dao.BoardDAO;
import kr.co.himedia.dto.BoardDTO;

@Service
public class ApiService {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired BoardDAO dao;

	public Map<String, Object> list(String page) {// current page
		
		int totalPage = dao.pages(); // total page
		ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
		int p = Integer.parseInt(page);
		Map<String, Object> map = new HashMap<String, Object>();
				
		if(totalPage >= p) {
			//offset 계산하기
			// (page 1 => offset 0)(page 2 => offset 5),...
			int offset = (p-1) * 5;
			list = dao.list(offset); // list
			map.put("list", list);			
			map.put("pages", totalPage);
			map.put("page", page);
			map.put("total", dao.total()); // 페이지네이션
		}		

		return map;
	}

	public BoardDTO detail(String idx) {
		// 조회수 증가(생략)
		return dao.detail(idx);
	}

	public boolean delete(String idx) {
		int row = dao.delete(idx);
		return row > 0;
	}

	public Map<String, Object> write(BoardDTO dto) {
		
		int row = dao.write(dto);
		Map<String, Object> map = new HashMap<String, Object>();

		map.put("idx", dto.getIdx());
		map.put("success", row>0);
		
		return map;
	}

}






























