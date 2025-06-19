package kr.co.himedia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.himedia.entity.Dept;
import kr.co.himedia.entity.Emp;
import kr.co.himedia.repo.DeptRepo;
import kr.co.himedia.repo.EmpRepo;

@Service
public class InsertService {
	
	@Autowired DeptRepo deptRepo;
	
	@Autowired EmpRepo empRepo;
	
	public int insertDept(List<Dept> list) {
		return deptRepo.saveAll(list).size();
	}
	
	public int insertEmp(List<Emp> list) {
		return empRepo.saveAll(list).size();
	}
	

}











