package kr.co.himedia.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.himedia.repo.EmployeeRepo;

@Service
public class CustomService {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired EmployeeRepo empRepo;

}
