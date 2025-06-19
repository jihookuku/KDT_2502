package kr.co.himedia.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.co.himedia.entity.User;

public interface UserRepo extends JpaRepository<User, Long> {

}
