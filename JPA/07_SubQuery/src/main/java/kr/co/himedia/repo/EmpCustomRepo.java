package kr.co.himedia.repo;

import java.util.List;

import kr.co.himedia.entity.Emp;

public interface EmpCustomRepo {
	
	List<Emp> findAllByLoc(List<String> param);
	
	List<Emp> searchByDeptName(String deptname);

}
