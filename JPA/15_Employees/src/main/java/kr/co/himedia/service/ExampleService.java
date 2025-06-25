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

}
