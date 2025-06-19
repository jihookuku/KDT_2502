package kr.co.himedia.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.co.himedia.entity.Emp;

public interface EmpRepo 
	extends JpaRepository<Emp, Integer>,EmpCustomRepo {

	Emp findByEname(String string);

}
