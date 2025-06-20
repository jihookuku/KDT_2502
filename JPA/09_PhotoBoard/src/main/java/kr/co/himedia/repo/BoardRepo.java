package kr.co.himedia.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.co.himedia.entity.Board;

//JAP 기본 메서드 + queryDSL 을 사용하기 위해 커스텀 repo 추가
public interface BoardRepo 
	extends JpaRepository<Board, Long>, BoardCustomRepo {

}
