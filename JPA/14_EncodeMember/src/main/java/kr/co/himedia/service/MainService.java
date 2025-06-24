package kr.co.himedia.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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
	private final BoardRepo bbsRespo;
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

}












