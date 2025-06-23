package kr.co.himedia.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.co.himedia.entity.Board;

public interface BoardRepo 
extends JpaRepository<Board, Long>, BoardCustomRepo {

}
