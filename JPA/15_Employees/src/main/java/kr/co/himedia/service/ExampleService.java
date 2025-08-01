package kr.co.himedia.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import kr.co.himedia.repo.ExampleRepo;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ExampleService {
	
	private final ExampleRepo repo;
	
	public List<Map<String, Object>> exam1() {
		return repo.exam1();
	}

	public List<String> exam2() {
		return repo.exam2();
	}

	public List<Map<String, Object>> exam3() {
		return repo.exam3();
	}

	public List<Map<String, Object>> exam4() {
		return repo.exam4();
	}

	public List<Map<String, Object>> exam5() {
		return repo.exam5();
	}

	public List<Map<String, Object>> exam6() {
		return repo.exam6();
	}

}
