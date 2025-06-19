package kr.co.himedia.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.co.himedia.entity.Post;

public interface PostRepo extends JpaRepository<Post, Long> {

}
