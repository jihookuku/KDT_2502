package kr.co.himedia.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.co.himedia.entity.Reply;

public interface ReplyRepo extends JpaRepository<Reply, Long> {

}
