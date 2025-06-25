package kr.co.himedia.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import kr.co.himedia.entity.key.SalaryKey;
import lombok.Data;

@Entity
@Data
public class Salaries {
	/*
	private int empNo;	
	private LocalDate fromDate;
	*/
	
	@EmbeddedId
	private SalaryKey key;
		
	private int salary;
	
	@Column(name="to_date")
	private LocalDate toDate;
	
	@ManyToOne
	@JoinColumn(name="emp_no")
	@MapsId("empNo")
	private Employees emp;

}





