package kr.co.himedia.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.himedia.dao.BbsDAO;
import kr.co.himedia.dto.BbsDTO;

@Service
public class BbsService {
	@Autowired
	BbsDAO dao;
	private int content_count = 5; // 한페이지당 몇개?

	public List<BbsDTO> list(int page) {
		int offset = (page - 1) * content_count;
		return dao.list(offset, content_count);
	}

	public BbsDTO detail(int idx) {
		return dao.detail(idx);
	}

	public boolean write(BbsDTO content) {
		int row = dao.write(content);
		return row > 0 ? true : false;
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
