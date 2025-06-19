package kr.co.himedia.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_no")
	private long userNo; // 변수명에 _가 들어가면 JpaRepository 에서 인식을 못한다.
	
	@Column(unique = true) // 유니크 키 설정
	private String id;
	
	private String name;
	
	/* mappedBy : 왜래키의 주인 이라는 의미
	 * orphanRemoval : 부모가 없는 엔티티의 삭제 여부
	 * Cascade.PERSIST : insert
	 * Cascade.MERGE	: select + update
	 * Cascade.REMOVE	: delete
	 * Cascade.REFRESH : 복원
	 * Cascade.DETACH	: 변경 감지나 저장 대상 아님
	 * Cascade.ALL : 위내용 전부 포함
	 */
	@OneToMany(mappedBy = "user",
			orphanRemoval = true,
			cascade = CascadeType.ALL)
	//@JsonIgnore // 해결방법 1
	@JsonManagedReference
	private List<Post> posts = new ArrayList<Post>();

	public long getUserNo() {
		return userNo;
	}

	public void setUserNo(long userNo) {
		this.userNo = userNo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	

}













