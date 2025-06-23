package kr.co.himedia.service;

import org.springframework.stereotype.Service;

import kr.co.himedia.entity.Member;
import kr.co.himedia.repo.MemberRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class MemberService {	

	
	private final MemberRepo repo;

	public Member login(String id, String pw) {
		return repo.findByIdAndPw(id,pw);
	}
	
}
