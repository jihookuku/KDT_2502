package kr.co.himedia.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Dept {
	
	@Id
	private int deptno;
	
	private String deptname;
	
	private String loc;
	
	/* 사용해야 하는 경우가 아니라면 양방향 참조는 하지 않는 것이 좋다.
	@OneToMany
	private List<Emp> emp;
	*/
}
