package kr.co.himedia.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import kr.co.himedia.entity.key.DeptEmpKey;
import lombok.Data;

@Entity
@Table(name="dept_manager")
@Data
public class DeptManager {
	/*
	private int emp_no;	
	private int dept_no;
	*/
	
	@EmbeddedId
	private DeptEmpKey key;
	
	@Column(name="from_date")
	private LocalDate fromDate;
	
	@Column(name="to_date")
	private LocalDate toDate;
	
	@ManyToOne
	@JoinColumn(name="emp_no")
	@MapsId("empNo")
	private Employees emp;
	
	
	@ManyToOne
	@JoinColumn(name="dept_no")
	@MapsId("deptNo")
	private Departments dept;







}
