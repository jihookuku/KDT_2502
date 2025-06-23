package kr.co.himedia.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.co.himedia.entity.Member;

public interface MemberRepo extends JpaRepository<Member, String> {

	Member findByIdAndPw(String id, String pw);

}
