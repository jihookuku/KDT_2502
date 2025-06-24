package kr.co.himedia.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import kr.co.himedia.entity.Board;
import kr.co.himedia.entity.Member;
import kr.co.himedia.repo.BoardRepo;
import kr.co.himedia.repo.MemberRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class MainService {
	
	private final MemberRepo memRepo;
	private final BoardRepo bbsRepo;
	private final PasswordEncoder encoder;
	
	public boolean overlay(String id) {
		Member member = memRepo.findById(id).orElse(new Member());
		log.info("member : "+member);		
		return member.getId() != null;
	}

	public boolean join(Member dto) {		
		
		//pw 가 평문으로 들어가면 안된다.
		// 그래서 암호화 후...
		String hash = encoder.encode(dto.getPw());
		// 다시 넣어 준다.
		dto.setPw(hash);
		// 그리고 저장
		Member member = memRepo.save(dto);
		log.info("member : "+member);
		return member != null;
	}

	public boolean login(String id, String pw) {
		
		// 1. 해당 id 의 정보를 가져온다.(null 로 올 수 있다.)
		Member member = memRepo.findById(id).orElse(null);
		
		if(member == null) {
			return false;
		}
		
		// 2. 암호화된 비밀번호 추출
		String hash = member.getPw();
		// 3. 가져온 비밀번호와 matches 로 비교
		return encoder.matches(pw, hash);
	}

	public Map<String, Object> list(int limit, int offset) {		
		List<Board> list = bbsRepo.searchAll(limit,offset);	
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		return map;
	}

}












