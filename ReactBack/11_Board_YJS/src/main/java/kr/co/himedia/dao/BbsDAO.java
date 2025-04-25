package kr.co.himedia.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import kr.co.himedia.dto.BbsDTO;

@Mapper
public interface BbsDAO {

	List<BbsDTO> list(int offset, int content_count);

	BbsDTO detail(int idx);

	int write(BbsDTO content);

	int update(BbsDTO content);

	int delete(int idx);

	int pages();

	int fileWrite(int idx, String ori_filename, String new_filename);

	List<Map<String, String>> photoList(String idx);

	Map<String, String> fileInfo(String file_idx);

}
