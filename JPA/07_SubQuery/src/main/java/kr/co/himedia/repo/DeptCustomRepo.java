package kr.co.himedia.repo;

import java.util.List;

import kr.co.himedia.entity.Dept;

public interface DeptCustomRepo {
	
	List<Dept> findDeptByName(String name);

}
