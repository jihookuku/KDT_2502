package kr.co.himedia.entity.key;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class DeptEmpKey implements Serializable {
	
	@Column(name="emp_no")
	private int empNo;
	
	@Column(name="dept_no", columnDefinition = "CHAR(4)")
	private String deptNo;

}
