package kr.co.himedia.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import kr.co.himedia.dto.MemberDTO;
@Mapper
public interface MemberDAO {

	int join(MemberDTO dto);

	MemberDTO datail(String id);

	String login(String id, String pw);

	ArrayList<MemberDTO> list(Map<String, String> param);

	int update(Map<String, String> param);

	List<MemberDTO> multi(List<String> userName);

	MemberDTO detail(String id);

}







