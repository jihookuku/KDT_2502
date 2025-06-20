package kr.co.himedia.service;

import org.springframework.stereotype.Service;

import kr.co.himedia.repo.BoardRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j // lombok 에서 log 를 쓸 수 있게 해 준다.
@RequiredArgsConstructor // lombok 에서 생성자 주입을 자동으로 해 준다.
public class BoardService {

	private final BoardRepo repo;
	
}
