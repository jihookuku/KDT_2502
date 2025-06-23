package kr.co.himedia.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.co.himedia.entity.Emp;
import kr.co.himedia.repo.CustomRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class PageService {
	
	private final CustomRepo repo;

	public List<Emp> join(int page, int limit) {
		int offset = (page-1)*limit;
		return repo.join(offset,limit);
	}

	public List<Emp> fetchJoin(int page, int limit) {
		int offset = (page-1)*limit;
		return repo.fetchJoin(offset,limit);
	}

	public List<Emp> fetchJoin2(int page, int limit) {
		int offset = (page-1)*limit;
		return repo.fetchJoin2(offset,limit);
	}

}








