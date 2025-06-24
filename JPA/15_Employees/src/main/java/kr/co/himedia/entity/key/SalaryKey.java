package kr.co.himedia.entity.key;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class SalaryKey implements Serializable {
	
	@Column(name="emp_no")
	private int empNo;

	@Column(name="from_date")
	private LocalDate fromDate;
	
}
