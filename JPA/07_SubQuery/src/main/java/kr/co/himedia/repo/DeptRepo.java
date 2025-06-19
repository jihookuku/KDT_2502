package kr.co.himedia.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.co.himedia.entity.Dept;

// JpaRepository = CrudRepository + 추가기능 
public interface DeptRepo 
	extends JpaRepository<Dept, Integer> {

}
