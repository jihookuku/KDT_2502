package kr.co.himedia.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Departments {
	
	// char(4) 고정형은 자바에서 표현이 불가능
	// 그런 타입은 따로 지정을 해줘야 한다.
	@Id
	@Column(name="dept_no", columnDefinition = "CHAR(4)")
	private String deptNo;
	
	@Column(name="dept_name",unique = true)
	private String deptName;

}
