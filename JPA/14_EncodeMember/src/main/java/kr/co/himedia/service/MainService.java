package kr.co.himedia.service;

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
	
	public boolean overlay(String id) {
		Member member = memRepo.findById(id).orElse(new Member());
		log.info("member : "+member);		
		return member.getId() != null;
	}

}
