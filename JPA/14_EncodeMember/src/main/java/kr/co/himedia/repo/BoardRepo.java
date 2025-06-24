package kr.co.himedia.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import kr.co.himedia.entity.Board;

public interface BoardRepo 
	extends JpaRepository<Board, Long> {

	// select * from bbs order by idx desc limit 5 offset 0;
	// factory.selectFrom(bbs).orderby(bbs.idx.desc()).limit(5).offset(0)
	@Query(value="SELECT * FROM bbs ORDER BY idx DESC LIMIT :limit OFFSET :offset", nativeQuery=true)
	List<Board> searchAll(@Param("limit") int limit, @Param("offset") int offset);

}
