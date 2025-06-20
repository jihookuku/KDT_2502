package kr.co.himedia.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import kr.co.himedia.entity.Emp;
import kr.co.himedia.repo.JoinRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class JoinService {

	private final JoinRepo repo;
	
	public List<Emp> empJoinDept(){
		return repo.empJoinDept();
	}

	public List<Map<String, Object>> empRightJoinDept() {
		return repo.empRightJoinDept();
	}

}
